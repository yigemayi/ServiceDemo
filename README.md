# ServiceDemo备忘

### 定义Service的IBinder方法
+ 扩展Binder,适用与同一个进程
+ 使用Messenger
+ 使用AIDL
### 知识备忘
+ 通过bindService()可以绑定Service，而Service的onBind()方法用于返回定义了客户端和服务端交互接口的IBinder对象。
+ bindService()立即无值返回，当Android系统创建了客户端和服务端的连接时，会回调ServiceConnection的onServiceConnected(),向客户端传递与服务端通信的Binder对象。
+ 多个客户端可以连接同一个服务端，但是只有第一个客户端连接时，系统才调用Service的onBind()方法检索IBinder，系统随后无需再次调用onBind()便将IBinder对象传递至其他绑定的客户端。
