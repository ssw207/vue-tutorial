# Vue-CLI 구성

# CLI - @vue/cli

vue create등 기본적인 명령어를 제공한다.

# CLI Server - @vue/cli-service

webpack을 통해 에플리케이션의 개발서버 실행, 빌드등을 처리
ex) `webpack`, `webpack-dev-server`

# CLI PlugIn - @vue/cli-plugin

`Babel, ESlint`등 선택적으로 설치가 필요한 플러그인을 관리. 프로젝트 생성이후 포함 할 수 도 있다.

# 설치

## vue-cli

```
npm install -g @vue/cli
yarn global add @vue/cli
```

`vue --version` 설치 버전 체크 가능

## vue-cli-service

```
npm install -g @vue/cli-service-global
```

vue파일을 직접 실행 할 수 있게한다.

### vue serve 옵션

```
Usage: serve [options] [entry]

serve a .js or .vue file in development mode with zero config

Options:

-o, --open Open browser
-c, --copy Copy local url to clipboard
-p, --port <port> Port used by the server (default: 8080 or next available port)
-h, --help Output usage information

```

`vue serve` `vue serve MyComponent.vue` 명령어로 실행가능

### vue build 옵션

```
Usage: build [options] [entry]

build a .js or .vue file in production mode with zero config


Options:

  -t, --target <target>  Build target (app | lib | wc | wc-async, default: app)
  -n, --name <name>      name for lib or web-component (default: entry filename)
  -d, --dest <dir>       output directory (default: dist)
  -h, --help             output usage information
```

`vue build MyComponent.vue` 명령어로 빌드가능

# 프로젝트 생성

## cli 생성

```
vue create hello-world
```

프로젝트에 추가할 라이브러리를 선택할수 있다.

### create명령어

```
Usage: create [options] <app-name>

create a new project powered by vue-cli-service


Options:

  -p, --preset <presetName>       Skip prompts and use saved or remote preset
  -d, --default                   Skip prompts and use default preset
  -i, --inlinePreset <json>       Skip prompts and use inline JSON string as preset
  -m, --packageManager <command>  Use specified npm client when installing dependencies
  -r, --registry <url>            Use specified npm registry when installing dependencies
  -g, --git [message|false]       Force / skip git initialization, optionally specify initial commit message
  -n, --no-git                    Skip git initialization
  -f, --force                     Overwrite target directory if it exists
  -c, --clone                     Use git clone when fetching remote preset
  -x, --proxy                     Use specified proxy when creating project
  -b, --bare                      Scaffold project without beginner instructions
  -h, --help                      Output usage information
```

## gui 생성

```
vue ui
```

플러그인 목록을 검색, 설치까지 할수 있다.

# 플러그인 설치

add 명령어 사용

```
vue add axios // or vue add vue-cli-plugin-axios
```

src > plugins Vue.use()가 자동으로 생성되어있다.
axios.js가 main.js에 import

# 참고

https://cli.vuejs.org/guide/installation.html
https://kdydesign.github.io/2019/04/22/vue-cli3-tutorial/

```

```
