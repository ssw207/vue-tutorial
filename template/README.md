# 템플릿 문법

## 보간법(Interpolation)

### 문자열

```
new Vue({
  data :{
    msg : '{{msg}} 이렇게 접근가능'
  }
});
```

```
<span>메시지: {{ msg }}</span>
```

```
<span v-once>다시는 변경하지 않습니다: {{ msg }}</span>
```

### 원시 HTML

이중 중괄호(mustaches)는 HTML이 아닌 일반 텍스트로 데이터를 해석합니다. 실제 HTML을 출력하려면 `v-html` 디렉티브를 사용해야 합니다.

```
<p>Using mustaches: {{ rawHtml }}</p>
<p>Using v-html directive: <span v-html="rawHtml"></span></p>
```

### 속성

{{는 html속성에 사용불가}}

```
<div v-bind:id="dynamicId"></div>
```

```
<button v-bind:disabled="isButtonDisabled">Button</button>
```

`isButtonDisabled`가 `null,undefined,false` 일경우 `disabled` 속성은 적용되지 않음

### Javascript 표현식

데이터 바인딩 내에서 javascirpt 문법을 사용 할 수 있습니다.

```
{{ number + 1 }}

{{ ok ? 'YES' : 'NO' }}

{{ message.split('').reverse().join('') }}

<div v-bind:id="'list-' + id"></div>
```

각 바인딩에는 하나으 표현식만 포함될 수 있어서 아래처럼 작성하면 안됩니다.

``

<!-- 아래는 구문입니다, 표현식이 아닙니다. -->

{{ var a = 1 }}

<!-- 조건문은 작동하지 않습니다. 삼항 연산자를 사용해야 합니다. -->

{{ if (ok) { return message } }}
``

### 디렉티브

`v-` 접두사가 있는 특수속성. 디렉티브 속성의 값은 단일 javascript 표현식이 됩니다.
(`v-for`제외) 디렉티브 속성은 표현식(`v-seen="표현식"`)의 값이 변경 될 때 반영적으로 DOM에 적용하는것 입니다.

```
<p v-if="seen">이제 나를 볼 수 있어요</p>
```

seen 값이 true/false 로 변경되면 <p> 엘리먼트를 삽입 or 제거합니다.

### 전달인자

일부 디렉티브는 콜론으로 표시되는 "전달인자"를 사용할 수 있습니다.

```
<a v-bind:href="url"> ... </a>
```

위의 "href" 전달인자는 `<a>`태그의 `href`속성을 `url`의 값에 파인딩하는 `v-bind` 디렉티브에게 알려줍니다.

### 동적 전달인자 (2.6.0+ 추가)

```
<!--
동적 전달인자는 "동적 전달인자의 형식 제약"의 부분에서 후술되는바와 같이,
조금의 제약이 있는 점에 주의해주세요
-->
<a v-bind:[attributeName]="url"> ... </a>
```

예를들어 아래와 같은 Vue 인스턴스는 `v-bind:href`와 동일합니다.

```
var app = new Vue({
  data : {
    attributeName : 'href'
  }
})
```
