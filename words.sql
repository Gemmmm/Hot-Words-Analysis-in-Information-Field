/*
Navicat SQL Server Data Transfer

Source Server         : sqlserver
Source Server Version : 105000
Source Host           : 127.0.0.1:1433
Source Database       : test
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 105000
File Encoding         : 65001

Date: 2019-01-16 21:14:16
*/


-- ----------------------------
-- Table structure for words
-- ----------------------------
DROP TABLE [dbo].[words]
GO
CREATE TABLE [dbo].[words] (
[name] varchar(255) NULL DEFAULT NULL ,
[expl] varchar(1000) NULL DEFAULT NULL ,
[type] varchar(255) NULL DEFAULT NULL ,
[val] int NULL DEFAULT NULL ,
[webname] varchar(255) NULL ,
[id] int NOT NULL IDENTITY(1,1) ,
[webaddr] varchar(255) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[words]', RESEED, 45)
GO

-- ----------------------------
-- Indexes structure for table words
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table words
-- ----------------------------
ALTER TABLE [dbo].[words] ADD PRIMARY KEY ([id])
GO
