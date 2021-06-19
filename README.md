# poi-tl-ext
![GitHub](https://img.shields.io/github/license/draco1023/poi-tl-ext) ![JDK](https://img.shields.io/badge/jdk-1.8-blue)

# Maven

```xml
<dependency>
    <groupId>com.wgzhao.poi</groupId>
    <artifactId>poi-tl-ext</artifactId>
    <version>1.8.0</version>
</dependency>
```

# 扩展功能

- 支持渲染`HTML`字符串，插件`HtmlRenderPolicy`的使用方法如下（也可参考[文档](http://deepoove.com/poi-tl/#_%E4%BD%BF%E7%94%A8%E6%8F%92%E4%BB%B6)）

  ```java
  HtmlRenderPolicy htmlRenderPolicy = new HtmlRenderPolicy();
  Configure configure = Configure.builder()
          .bind("key", htmlRenderPolicy)
          .build();
  Map<String, Object> data = new HashMap<>();
  data.put("key", "<p>Hello <b>world</b>!</p>");
  XWPFTemplate.compile("input.docx", configure).render(data).writeToFile("output.docx");
  ```
  
  _目前实现了富文本编辑器可实现的大部分效果，后续继续改进..._

- 支持渲染`MathML`字符串，插件类为`MathMLRenderPolicy`
- 支持渲染`LaTeX`字符串，插件类为`LaTeXRenderPolicy`

# 版本说明

因为 [poi-tl](https://github.com/Sayi/poi-tl.git) 的发行版本之间并不完全兼容，所以这里的版本号就和 `poi-tl` 版本保持一致
大致上前两位的版本相符合则兼容。

比如 `1.8.x` 就和 `poi-tl` 的 `1.8.x` 兼容，如有特别情况，会临行说明