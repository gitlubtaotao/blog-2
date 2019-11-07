module.exports = `
/*全局属性*/
.layout {
  font-size: 14px;
  color: #333;
  padding: 10px;
  line-height: 1.6;
  word-spacing: 0px;
  letter-spacing: 0px;
  word-wrap: break-word;
  font-family: Optima-Regular, Optima, PingFangSC-light, PingFangTC-light, 'PingFang SC', Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

/*段落*/
p {
  font-size: 14px;
  padding-top: 5px;
  padding-bottom: 5px;
  margin: 0;
  line-height: 26px;
  color: #333;
}

/*标题*/
h1,
h2,
h3,
h4,
h5,
h6 {
  margin-top: 40px;
  margin-bottom: 20px;
  font-weight: bold;
  color: #333;
}
h1 {
  font-size: 24px;
}
h2 {
  font-size: 20px;
}
h3 {
  font-size: 18px;
}
h4 {
  font-size: 16px;
}
h5 {
  font-size: 14px;
}
h6 {
  font-size: 14px;
}

/*列表*/
ul,
ol {
  margin-top: 5px;
  margin-bottom: 5px;
  padding-left: 20px;
	color: #333;
	font-size: 14px;
}
ul {
  list-style-type: disc;
}
ol {
  list-style-type: decimal;
}
li {
  margin-top: 5px;
  margin-bottom: 5px;
  line-height: 26px;
  text-align: left;
	color: #333;
	font-size: 14px;
}

/*引用*/
blockquote {
  display: block;
  font-size: 0.9em;
  overflow: auto;
  overflow-scrolling: touch;
  border-left: 3px solid rgba(0, 0, 0, 0.4);
  background: rgba(0, 0, 0, 0.05);
  color: #6a737d;
  padding-top: 10px;
  padding-bottom: 10px;
  padding-left: 20px;
  padding-right: 10px;
  margin-bottom: 20px;
  margin-top: 20px;
}

blockquote p {
  margin: 0px;
  color: #333;
  line-height: 26px;
}

.table-of-contents a {
  border: none;
  color: #333;
  font-weight: normal;
}

/*链接*/
a {
  text-decoration: none;
  color: #1e6bb8;
  word-wrap: break-word;
  font-weight: bold;
}

/*加粗*/
strong {
  font-weight: bold;
  color: #333;
}

/*斜体*/
em {
  font-style: italic;
  color: #333;
}

/*加粗斜体*/
strong em {
  font-weight: bold;
  color: #333;
}

/*删除线*/
del {
  font-style: italic;
  color: #333;
}

/*分隔线*/
hr {
  height: 1px;
  margin: 0;
  margin-top: 10px;
  margin-bottom: 10px;
  border: none;
  border-top: 1px solid black;
}

/*代码块*/
pre {
  overflow-x: scroll;
	border:2px solid #eee;
	margin-top: -25px;
}
pre code {
  display: -webkit-box !important;
  font-family: Operator Mono, Consolas, Monaco, Menlo, monospace;
  border-radius: 0px;
  font-size: 12px;
  padding: 2px;
}
pre code span {
  line-height: 26px;
}

/*行内代码*/
p code, li code{
  font-size: 14px;
  word-wrap: break-word;
  padding: 2px 4px;
  border-radius: 4px;
  margin: 0 2px;
  color: #1e6bb8;
  background-color: rgba(27,31,35,.05);
  font-family: Operator Mono, Consolas, Monaco, Menlo, monospace;
  word-break: break-all;
}

/*图片*/
img {
  display: block;
  margin: 0 auto;
  width: 100%;
}

/*图片*/
figure {
  margin: 0;
  margin-top: 10px;
  margin-bottom: 10px;
}

/*图片描述文字*/
figcaption {
  margin-top: 5px;
  text-align: center;
  color: #888;
  font-size: 14px;
}

/*表格*/
table {
  display: table;
  text-align: left;
}
tbody {
  border: 0;
}

table tr {
  border: 0;
  border-top: 1px solid #ccc;
  background-color: white;
}

table tr:nth-child(2n) {
  background-color: #F8F8F8;
}

table tr th,
table tr td {
  font-size: 16px;
  border: 1px solid #ccc;
  padding: 5px 15px;
  text-align: left;
  min-width: 70px;
}

table tr th {
  font-weight: bold;
  background-color: #f0f0f0;
}

/* 微信代码块 */
.code-snippet__fix {
  word-wrap: break-word !important;
  ont-size: 14px;
  margin: 10px 0;
  display: block;
  color: #333;
  position: relative;
  background-color: rgba(0,0,0,0.03);
  border: 1px solid #f0f0f0;
  border-radius: 2px;
  display: flex;
  line-height: 20px;
  font-size: 12px;
}
.code-snippet__fix .code-snippet__line-index {
  counter-reset: line;
  flex-shrink: 0;
  height: 100%;
  padding: 1em;
  list-style-type: none;
  margin: 0;
}
.code-snippet__fix .code-snippet__line-index li {
  list-style-type: none;
  text-align: right;
}
.code-snippet__fix .code-snippet__line-index li::before {
  min-width: 1.5em;
  text-align: right;
  left: -2.5em;
  counter-increment: line;
  content: counter(line);
  display: inline;
  color: rgba(0,0,0,0.3);
}
.code-snippet__fix pre {
  overflow-x: auto;
  padding: 1em;
  padding-left: 1em;
  padding-left: 0;
  white-space: normal;
  flex: 1;
  -webkit-overflow-scrolling: touch;
}
.code-snippet__fix code {
  text-align: left;
  font-size: 14px;
  display: block;
  white-space: pre;
  display: flex;
  position: relative;
  font-family: Consolas,"Liberation Mono",Menlo,Courier,monospace;
  background: rgba(0,0,0,0);
  font-size: 12px;
}
.code-snippet__fix code span {
  line-height: 20px;
}
.code-snippet__fix ol li {
  margin: 0;
  padding: 2px;
  line-height: 20px;
}

/* 公式注释 */
.katex-mathml {
  display: none;
}

.katex {
  display: inline-block;
  line-height: 28px;
}

.math-img-inline {
  display: inline-block;
  line-height: inherit;
  height: 28px;
  width: auto;
  vertical-align: middle
}

.katex-inline {
  display: inline;
}

.math-img-block {
  width: 100%;
}

.footnote-word {
  color: #1e6bb8;
  font-weight: bold;
}

.footnote-ref {
  color: #1e6bb8;
  font-weight: bold;
}

.footnote-item {
  display: flex;
}

.footnote-num {
  display: inline;
  width: 10%; /*神奇，50px就不可以*/
  background: none;
  font-size: 80%;
  opacity: 0.6;
  line-height: 26px;
  font-family: ptima-Regular, Optima, PingFangSC-light, PingFangTC-light, 'PingFang SC', Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

.footnote-item p {
  display: inline;
  font-size: 14px;
  width: 90%;
  padding: 0px;
  margin: 0;
  line-height: 26px;
  color: #333;
  word-break:break-all;
  width: calc(100%-50)
}`;
