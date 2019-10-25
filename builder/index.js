const fs = require('fs');
const path = require('path');
const marked = require('marked');
const juice = require('juice');
const basic = require('./styles/basic.js');
const theme = require('./styles/themes/green.js');
const code = require('./styles/code/xcode.js');
const MD_PATH = process.argv[2] || '';

if (!MD_PATH) return console.error('指定生成的 MarkDown 路径');
if (!fs.existsSync(MD_PATH)) return console.error('指定生成的 MarkDown 文件不存在');

const fileName = MD_PATH.substr(MD_PATH.lastIndexOf('/') + 1);
const content = fs.readFileSync(MD_PATH, 'utf-8');

// 同步使用 highlight.js 转换代码
marked.setOptions({
	highlight: function(code) {
		return require('highlight.js').highlightAuto(code).value;
	}
});

const HTMLString = juice.inlineContent(`<section class="layout">${marked(content)}</section>`, basic + theme + code, {
	inlinePseudoElements: true
});

const mkdirs = function(pathDir, callback) {
	// 判断文件夹是否存在
	if (fs.existsSync(pathDir)) {
		callback();
	} else {
		mkdirs(path.dirname(pathDir), function() {
			fs.mkdir(pathDir, callback);
		});
	}
};

// 生成文件夹
const date = new Date();
const dirName = `${date.getFullYear()}${date.getMonth() + 1}${date.getDate()}`;
const filePath = `dist/${dirName}`;
mkdirs(filePath, () => {
	fs.writeFileSync(filePath + `/${fileName}`, HTMLString);
});
