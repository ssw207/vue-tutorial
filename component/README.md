# 컴포넌트 설계 주의점

props는 해당 컴포넌트에서 절대적으로 필요한 요소로 생성하고
watch의 사용을 최소화하고
공통적인 methods와 같은 Script들은 javaScript 파일로 별로 분리하는 것이 좋으며
컴포넌트 간의 깊은 바인딩(deep)은 자제해야 한다.
=>특정페이지에 종속적이면 안된다.

# 컴포넌트 등록 - 사용

## 전역

프로그래밍의 전역변수와 도일, 인스턴스 생성후 어느페이지, 컴포넌트에서 사용할수 있다.

## 지역

지역변수와 동일, 빌드시스템으로 빌드시 사용하지않는 지역컴포넌트는 포함되지 않는다.

# 컴포넌트간의 관계

컴포넌트A에서 B컴포넌트를 사용 할 수 있다.

## 부모

props를 통해 자식에게 데이터 전달

## 자식

events를 동해 부모에게 메시지 전달

# 숫자전달

```
<!-- 이것은 일반 문자열 "1"을 전달합니다. -->
<comp some-prop="1"></comp>
```

문자 1전달

```
<!-- 이것은 실제 숫자로 전달합니다. -->
<comp v-bind:some-prop="1"></comp>
```

v-bind는 js표현식으로 평가되므로 숫자 1전달

# 데이터 흐름

부모 -> 자식으로 props를 통해 단반항으로만 데이터가 전달된다.
단 객체, 배열은 참조로 전달되므로 하위객체에서 변경할경우 부모상태에 영향을 준다.

# props 변경

## 초기화

```
props: ['initialCounter'],
data: function () {
  return { counter: this.initialCounter }
}
```

## 계산된 속성

```
props: ['size'],
computed: {
  normalizedSize: function () {
    return this.size.trim().toLowerCase()
  }
}
```

# prop 검증

### type

String
Number
Boolean
Function
Object
Array
Symbol

# 컴포넌트에 html 속성추가

bs-date-input 컴포넌트에 data-3d-date-picker="true" 속성을 추가한다.

```
<bs-date-input data-3d-date-picker="true"></bs-date-input>
```

#사용자 지정 이벤트 v-on

```
$on(eventName)을 사용하여 이벤트를 감지 하십시오.
$emit(eventName)을 사용하여 이벤트를 트리거 하십시오.
```

$on 과 $emit 는 addEventListener 와 dispatchEvent의 별개

부모 컴포넌트에서 브라우저 이벤트 사용시

```
<button-counter v-on:click.native="incTotal"></button-counter
```

# 자식컴포넌트에서 부모데이터 변경

자식컴포넌트에서 명시적으로 이벤트 방출

```
this.$emit('update:foo', newValue)
```

부모 컴포넌트에서 선언

```
<comp :foo.sync="bar"></comp>
```

`<comp :foo="bar" @update:foo="val => bar = val"></comp>` 와 동일

# 참고

https://kdydesign.github.io/2019/04/27/vue-component/
https://github.com/chrisvfritz/vue-enterprise-boilerplate
