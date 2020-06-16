# 责任链模式解决多层嵌套if else
## 多层嵌套if写法改用责任链模式
例如:我们先看一个普通的下单拦截接口,基本逻辑，参数安全拦截，次数拦截，规则拦截，都通过，返回允许下单，任意一个失败，返回对应的失败原因。
例子见order包下
我们希望达到的目的
 * 代码没有这么多if else嵌套，可读性高
 * 如果新增新的拦截逻辑简单方便，不影响原本的逻辑，扩展性好
 * 可以很方便地调换拦截逻辑顺序，低耦合
## 责任链模式
责任链，顾名思义，就是用来处理相关事务责任的一条执行链，
执行链上有多个节点，每个节点都有机会（条件匹配）处理请求事务，
如果某个节点处理完了就可以根据实际业务需求传递给下一个节点继续处理或者返回处理完毕。

## 总结
**嵌套太深的if else用责任链模式，而分支太多的if else则适合策略模式**
### 使用责任链模式后好处:
* 新增拦截逻辑，只需要再实现一个AbstractFilter类即可
* 修改拦截顺序，只需要修改Order注解的大小，越小，优先级越高
* 代码清晰，所有处理逻辑下沉到实现类中
### 缺点:
* 逻辑更复杂，用了链式等数据结构，要注意单例的问题，不能重复使用
* 类数量激增，一个拦截器就一个类(责任链模式配合lambda表达式就不会产生类激增的问题)

不是什么地方都适合使用设计模式，如果逻辑简单，你硬要使用设计模式，
只会带来结构上的复杂，大家可以按照大家的业务场景来使用。
## 来源
https://mp.weixin.qq.com/s/tVynPGM2Sdw4mFyem3il2g

# 设计模式参考
https://github.com/youngMen1/java-design-patterns-learn