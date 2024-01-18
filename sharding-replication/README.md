

主库配置

1. 修改Mysql数据库的配置文件/etc/my.cnf

```
log-bin=mysql-bin   #[必须]启用二进制日志
server-id=200       #[必须]服务器唯一ID(唯一即可)
```

2. 重启服务

```bash
systemctl restart mysqld
```

3.  创建数据同步的用户并授权

```bash
GRANT REPLICATION SLAVE ON *.* to 'xiaoming'@'%' identified by 'Root@123456';
```

4. 登录Mysql数据库，查看master同步状态

执行下面SQL，记录下结果中**File**和**Position**的值

```bash
show master status;
```


从库配置

1. 修改Mysql数据库的配置文件/etc/my.cnf

```
server-id=201 	#[必须]服务器唯一ID
```

2. 重启服务

```bash
systemctl restart mysqld
```

3. 登录Mysql数据库，设置主库地址及同步位置

```sql
change master to master_host='192.168.200.200',master_user='xiaoming',master_password='Root@123456',master_log_file='mysql-bin.000001',master_log_pos=154;

start slave;
```

4. 查看从数据库的状态

```sql
show slave status;
```

然后通过状态信息中的 Slave_IO_running 和 Slave_SQL_running 可以看出主从同步是否就绪，如果这两个参数全为Yes，表示主从同步已经配置完成。