出现错误:无法解决，放弃！
> java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
  
  	at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:103)
  	at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:72)
  	at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:120)
  	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTestContextManager(SpringJUnit4ClassRunner.java:151)
  	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.<init>(SpringJUnit4ClassRunner.java:142)
  	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
  	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
  	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
  	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
  	at org.junit.internal.builders.AnnotatedBuilder.buildRunner(AnnotatedBuilder.java:104)
  	at org.junit.internal.builders.AnnotatedBuilder.runnerForClass(AnnotatedBuilder.java:86)
  	at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:70)
  	at org.junit.internal.builders.AllDefaultPossibilitiesBuilder.runnerForClass(AllDefaultPossibilitiesBuilder.java:37)
  	at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:70)
  	at org.junit.internal.requests.ClassRequest.createRunner(ClassRequest.java:28)
  	at org.junit.internal.requests.MemoizingRequest.getRunner(MemoizingRequest.java:19)
  	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:49)
  	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)
  	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)
  	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)
  Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Unresolvable class definition; nested exception is java.lang.NoSuchMethodError: org.springframework.core.KotlinDetector.isKotlinReflectPresent()Z
  	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:145)
  	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:165)
  	at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:100)
  	... 19 more
  Caused by: java.lang.NoSuchMethodError: org.springframework.core.KotlinDetector.isKotlinReflectPresent()Z
  	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:184)
  	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:135)
  	... 21 more