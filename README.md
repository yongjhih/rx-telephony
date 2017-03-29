# RxTelephony

[![CircleCI](https://circleci.com/gh/yongjhih/rx-telephony.svg?style=shield)](https://circleci.com/gh/yongjhih/rx-telephony)
[![codecov](https://codecov.io/gh/yongjhih/rx-telephony/branch/master/graph/badge.svg)](https://codecov.io/gh/yongjhih/rx-telephony)

## Usage

```java
RxTelephony.phoneStateChanges().subscribe();
```

## Installation

RxJava2:

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih.rx-telephony:rx2-telephony:-SNAPSHOT'
    compile 'com.github.yongjhih.rx-telephony:rx2-telephony-kotlin:-SNAPSHOT'
}
```

RxJava1:

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih.rx-telephony:rx-telephony:-SNAPSHOT'
    compile 'com.github.yongjhih.rx-telephony:rx-telephony-kotlin:-SNAPSHOT'
}
```

## See Also

* https://github.com/yongjhih/rx-receiver

## LICENSE

Apache 2.0
