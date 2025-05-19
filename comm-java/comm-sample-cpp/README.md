# 工 程 简 介

演示声明式调用c 提供的服务

# 延 伸 阅 读

## `hystrix`参 考

```yaml
# hystrix服 务 熔 断 配 置 参 考 配 置
feign:
hystrix:
enabled: true
# 服 务 熔 断 配 置
hystrix:
command:
default: #配置服务降级全局超时时间
execution:
isolation:
thread:
timeoutInMilliseconds: 12000 #默认（1s即1000）
timeout:
#（默认true）开启超时熔断,为false将超时控制交给ribbon
enabled: true
circuitBreaker: #10秒内，5次请求，失败率在50%，熔断8秒。
requestVolumeThreshold: 5 #默认20 ，一个rolling window内最小的请求数。如果
  设为20， 10秒（Hystrix的滑动窗口算法）内发起了至少20次请求，失败率超过50%
  （errorThresholdPercentage）,从熔断开启后,不在调用该远程服务
sleepWindowInMilliseconds: 8000 #默认5S 休眠时长
errorThresholdPercentage: 50 #触发熔断的失败请求最小占比，默认50%
# 负 载 均 衡 配 置
ribbon:
MaxAutoRetries: 0 #（默认1次 不包括第一次）最大重试次数，当注册中心中可以找到服务，
  但是服务连不上时将会重试，如果注册中心中找不到服务则直接走断路器
MaxAutoRetriesNextServer: 1 #（默认0次 不包括第一次）切换实例的重试次数
OkToRetryOnAllOperations: false #对所有操作请求都进行重试，如果是get则可以，如果
  是post，put等操作没有实现幂等的情况下是很危险的,所以设置为false
ConnectTimeout: 3000 #（默认1s）请求连接的超时时间
ReadTimeout: 3000 #（默认1s）请求处理的超时时间
# Hystrix与 Ribbon的 默 认 请 求 超 时 时 间 都 是 1秒
# 在 接 口 调 用 的 时 候 ， 两 个 计 时 器 会 同 时 读 秒 。 所 以 建 议 配 置 Hystrix的 超 时 时 间 要 大 于
  Ribbon的 超 时 时 间 ， Ribbon重 试 超 时 后 ， 再 进 行 熔 断 处 理 。
  # OpenFeign默 认 开 启 Ribbon， 开 启 Hystrix需 要 添 加 配 置 。 当 开 启 Hystrix， 单 独 设 置
  Hystrix的 超 时 时 间 ， 可 能 会 小 于 Ribbon的 默 认 时 间 ， 会 出 现 不 确 定 的 结 果 。
  # 当 Hystrix超 时 时 间 < Ribbon超 时 时 间 ， 程 序 会 先 回 调 进 入 到 Hystrix的 fallback方 法 ，
  并 继 续 执 行 下 去 。 Ribbon会 继 续 发 送 请 求 ， 直 到 请 求 完 成 ， 或 达 到 重 试 次 数 ， Ribbon的 重 试
  也 就 没 有 了 意 义 。
  # Ribbon的 重 试 次 数 不 包 括 第 一 次 请 求 ， 如 果 MaxAutoRetries=1，
  MaxAutoRetriesNextServer=2， 则 最 大 请 求 次 数 为 6 （ (1+1)(2+1)） 次 ， 最 大 超 时 时 间 为
  (ConnectTimeout+ReadTimeout)*6
```

## `sentinel`配 置 参 考

https:
sentinelguard.io/zh-cn/docs/basic-api-resource-rule.html