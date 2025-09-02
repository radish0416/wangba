# 移除Java文件中的BOM字符
# BOM字符 (Byte Order Mark) 会导致Java编译器报错

$backendPath = "backend\src"

Write-Host "开始移除Java文件中的BOM字符..."

# 获取所有Java文件
$javaFiles = Get-ChildItem -Path $backendPath -Filter "*.java" -Recurse

$fixedCount = 0
$totalCount = $javaFiles.Count

foreach ($file in $javaFiles) {
    $content = Get-Content $file.FullName -Raw -Encoding UTF8
    
    # 检查是否以BOM字符开始
    if ($content.StartsWith([char]0xFEFF)) {
        Write-Host "移除BOM字符: $($file.Name)"
        
        # 移除BOM字符
        $contentWithoutBOM = $content.Substring(1)
        
        # 写回文件（不包含BOM）
        [System.IO.File]::WriteAllText($file.FullName, $contentWithoutBOM, [System.Text.UTF8Encoding]::new($false))
        
        $fixedCount++
    }
}

Write-Host "处理完成!"
Write-Host "总文件数: $totalCount"
Write-Host "修复文件数: $fixedCount"
Write-Host "跳过文件数: $($totalCount - $fixedCount)"