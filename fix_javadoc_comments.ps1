# 修复Java文件中的注释语法错误
# 主要问题：文件开头的Javadoc注释缺少开始的 "/" 字符

$backendPath = "backend\src\main\java"

Write-Host "开始修复Java文件中的注释语法错误..."

# 获取所有DTO、PO、VO文件
$javaFiles = Get-ChildItem -Path $backendPath -Filter "*.java" -Recurse | Where-Object { 
    $_.FullName -match "(\\dto\\|\\po\\|\\vo\\)" 
}

$fixedCount = 0
$totalCount = $javaFiles.Count

Write-Host "找到 $totalCount 个DTO/PO/VO文件需要检查"

foreach ($file in $javaFiles) {
    $content = Get-Content $file.FullName -Raw -Encoding UTF8
    
    # 检查是否以错误的注释开始 "**" 而不是 "/**"
    if ($content -match '^(\*\*\s*\n\s\*\s.*?\*/)') {
        Write-Host "修复注释: $($file.Name)"
        
        # 替换错误的注释开始符号
        $fixedContent = $content -replace '^(\*\*)', '/**'
        
        # 写回文件
        [System.IO.File]::WriteAllText($file.FullName, $fixedContent, [System.Text.UTF8Encoding]::new($false))
        
        $fixedCount++
    }
}

Write-Host "处理完成!"
Write-Host "检查文件数: $totalCount"
Write-Host "修复文件数: $fixedCount"
Write-Host "跳过文件数: $($totalCount - $fixedCount)"