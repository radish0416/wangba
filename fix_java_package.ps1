# 修复Java文件中package声明位置错误的问题
# package声明必须在import语句之前

$backendPath = "backend\src\main\java"

# 获取所有Java文件
$javaFiles = Get-ChildItem -Path $backendPath -Filter "*.java" -Recurse

Write-Host "开始修复Java文件的package声明位置..."

foreach ($file in $javaFiles) {
    Write-Host "处理文件: $($file.FullName)"
    
    # 读取文件内容
    $content = Get-Content $file.FullName -Raw -Encoding UTF8
    
    # 检查是否存在package在import之后的问题
    if ($content -match '(?s)import\s+.*?;\s*\n.*?package\s+[^;]+;') {
        Write-Host "  发现问题，正在修复..."
        
        # 提取注释部分（文件开头的注释）
        $commentMatch = [regex]::Match($content, '^(/\*\*[\s\S]*?\*/)')
        $comment = if ($commentMatch.Success) { $commentMatch.Value } else { "" }
        
        # 提取package声明
        $packageMatch = [regex]::Match($content, 'package\s+([^;]+);')
        $packageDeclaration = if ($packageMatch.Success) { $packageMatch.Value } else { "" }
        
        # 提取所有import语句（去重）
        $importMatches = [regex]::Matches($content, 'import\s+([^;]+);')
        $imports = @()
        $importSet = @{}
        foreach ($match in $importMatches) {
            $importStatement = $match.Value
            if (-not $importSet.ContainsKey($importStatement)) {
                $imports += $importStatement
                $importSet[$importStatement] = $true
            }
        }
        
        # 提取类定义和其余内容
        $afterPackagePattern = 'package\s+[^;]+;\s*(?:import\s+[^;]+;\s*)*(?:\s*\n)*(.*)'
        $remainingMatch = [regex]::Match($content, $afterPackagePattern, [System.Text.RegularExpressions.RegexOptions]::Singleline)
        $remaining = if ($remainingMatch.Success) { $remainingMatch.Groups[1].Value } else { "" }
        
        # 重新组织文件内容
        $newContent = ""
        if ($comment) {
            $newContent += $comment + "`n"
        }
        if ($packageDeclaration) {
            $newContent += $packageDeclaration + "`n`n"
        }
        if ($imports.Count -gt 0) {
            $newContent += ($imports -join "`n") + "`n`n"
        }
        $newContent += $remaining
        
        # 写回文件
        Set-Content -Path $file.FullName -Value $newContent -Encoding UTF8
        Write-Host "  修复完成"
    } else {
        Write-Host "  文件格式正确，跳过"
    }
}

Write-Host "批量修复完成！"