# mbxx_music
木本芽衣和迪小翔共同完成的在线音乐项目

目前已完成user_pwd数据库表的建立，generator基本使用


以下是主要功能

主页：
发现（推荐，排行榜，歌单，歌手，碟片）
我的音乐
朋友
商城
音乐人
下载客户端（一个下载链接）
检索

推荐（根据歌单类型和热度选取的歌单）
排行榜（绑定具体歌曲id，因为同一个名字的歌曲很多，分原创榜单（识别为原创后根据一周播放量取前50），和飙升榜单（同前取50））
歌单（限定50首歌曲，数据从数据库取）
朋友商城暂时不做
下载客户端先随意从一个固定地址根据版本号下载即可
检索（全文检索）


数据库：
用户
user_pwd（用户id，所属组织（后来定义权限），昵称，密码，出生年月，性别，登录状态，邮箱，行版本号（用来处理锁），建立日期，个性签名，职业，头像地址)


user_guanzhu(用户id，关注的歌手1/2/3......，创建的歌单1/2/3......，收藏的歌单1/2/3......)
user_singer(id,热门作品（按照播放量正序排列），所有专辑，艺人介绍，类型1/2/3，国籍，性别)

歌曲（id,歌名，歌曲图，歌手名1/2/3 伴奏1/2/3 类型1/2/3，时长，歌词（文件地址），是否原创，总播放量，发布日期，是否可播放（下架等暂时不能播放），所在专辑，存放地址）

歌单（id,歌单图片路径，创建日期，创建人id,创建人头像，创建人网名，收藏量，标签1/2/3，介绍）
歌单_sku(歌单id,歌曲id_1/id_2......)

客户端（版本id,版本号，存放地址）

用户权限 （暂不考虑）
播放列表（随机，单曲循环，轮播，跟随歌单，历史等  先不考虑）
