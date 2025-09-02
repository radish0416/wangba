# 修复Java文件中package声明缺少字母"p"的问题
# 将 "ackage" 修复为 "package"

$backendPath = "backend\src\main\java"

Write-Host "开始检查并修复Java文件中缺少'p'的package声明..."

# 获取所有Java文件
$javaFiles = Get-ChildItem -Path $backendPath -Filter "*.java" -Recurse

$fixedCount = 0
$totalCount = $javaFiles.Count
$affectedFiles = @()

Write-Host "扫描 $totalCount 个Java文件..."

foreach ($file in $javaFiles) {
    $content = Get-Content $file.FullName -Raw -Encoding UTF8
    
    # 检查是否存在缺少"p"的package声明
    if ($content -match "^ackage\s+") {
        Write-Host "修复文件: $($file.Name)"
        
        # 修复package声明：将文件开头的 "ackage" 替换为 "package"
        $fixedContent = $content -replace "^ackage(\s+)", "package`$1"
        
        # 写回文件
        [System.IO.File]::WriteAllText($file.FullName, $fixedContent, [System.Text.UTF8Encoding]::new($false))
        
        $fixedCount++
        $affectedFiles += $file.Name
    }
}

Write-Host "修复完成!"
Write-Host "检查文件数: $totalCount"
Write-Host "修复文件数: $fixedCount"

if ($fixedCount -gt 0) {
    Write-Host "修复的文件列表:"
    foreach ($fileName in $affectedFiles) {
        Write-Host "  - $fileName"
    }
    
    Write-Host ""
    Write-Host "验证修复结果..."
    
    # 验证是否还有未修复的文件
    $remainingIssues = 0
    foreach ($file in $javaFiles) {
        $content = Get-Content $file.FullName -Raw -Encoding UTF8
        if ($content -match "^ackage\s+") {
            Write-Host "警告: $($file.Name) 仍有问题"
            $remainingIssues++
        }
    }
    
    if ($remainingIssues -eq 0) {
        Write-Host "✓ 所有package声明已成功修复!"
    } else {
        Write-Host "⚠ 还有 $remainingIssues 个文件需要手动检查"
    }
} else {
    Write-Host "✓ 未发现package声明缺少'p'的问题"
}