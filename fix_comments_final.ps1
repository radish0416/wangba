# 修复Java文件中开头注释的语法错误
# 将 "**" 修复为 "/**"

$backendPath = "backend\src\main\java"

Write-Host "开始修复Java文件中的注释语法错误..."

# 获取所有有问题的Java文件
$javaFiles = Get-ChildItem -Path $backendPath -Filter "*.java" -Recurse | Where-Object { 
    $content = Get-Content $_.FullName -Raw -Encoding UTF8
    $content.StartsWith("**")
}

$fixedCount = 0
$totalCount = $javaFiles.Count

Write-Host "找到 $totalCount 个文件需要修复"

foreach ($file in $javaFiles) {
    Write-Host "修复文件: $($file.Name)"
    
    $content = Get-Content $file.FullName -Raw -Encoding UTF8
    
    # 修复注释开始符号：将文件开头的 "**" 替换为 "/**"
    $fixedContent = $content -replace '^(\*\*)', '/**'
    
    # 写回文件
    [System.IO.File]::WriteAllText($file.FullName, $fixedContent, [System.Text.UTF8Encoding]::new($false))
    
    $fixedCount++
}

Write-Host "修复完成!"
Write-Host "修复文件数: $fixedCount"