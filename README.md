## 更新记录
1. 基于微信小程序接口封装
	我用抓包工具抓取了天眼查小程序的接口，然后自己简单封装了一下，查询结果以Json形式返回，可以按照自己的需要提取更多的字段。这次只封装了两个接口，一个是搜索的接口，另一个是查询公司基本信息的接口，其他的接口需要自己封装。
2. 机器人验证
	之前在网站上查询，大概每查询一百次就会出现机器人验证。用小程序的接口查询，我检查测试了一下，循环四百多次查询也没有出现验证，至于具体什么时候出现验证，大家可以试验一下。
3. excel导出工具
	新增了一个excel的导出工具类，大家可以按照需求导出自己需要的字段。
4. 抓包天眼查微信小程序接口--爬取企业的 商标, 专利, 网站备案等专利数据; 并保存到mysql数据库; 建议登录后使用自己的jwt;
