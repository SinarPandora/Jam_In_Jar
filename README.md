# 罐装果酱

⚠️ 该项目仍在开发中，暂无发行版本

> 让更多人感受到 Bot 的乐趣

## 介绍

罐装果酱（Jam in Jar）是用于在本地部署多个果酱（一种 QQ 聊天机器人（又称为 Bot））实例的工具，并带有管理页面。该项目简化了 QQ 机器人的部署和配置流程，让更多人享受到 QQ 聊天机器人的乐趣。

## 果酱

> 果酱是一个基于语法简洁的中文步骤定义语言 SXDL ，可由用户添加行为的 QQ 聊天机器人。

罐装果酱将同时简化果酱的配置流程，让用户可以在不懂 SXDL 的情况下，通过简单的页面点击配置机器人的行为。该版本的果酱称作 "果酱Lite"。    
初步计划实现（迁移）如下功能：  
[ ] 聊天回复  
[ ] 图片/语音发送  
[ ] 禁言  
[ ] 等待  
[ ] 触发几率与活跃时间  
[ ] 自动唤醒/睡眠  
[ ] 其他原生CQ码生成和发送  
[ ] Roll 点

## 技术栈

* 后端：Quarkus with Kotlin + Mongodb + Akka
* 前端：Vue
* 聊天协议实现：[MiraiGo](https://github.com/Mrs4s/MiraiGo)


