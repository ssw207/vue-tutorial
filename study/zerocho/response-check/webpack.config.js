const path = require('path');
const {VueLoaderPlugin} = require("vue-loader");

module.exports = { // 노드 모듈 설정 웹팩설정을 넣는다. 웹팩은 자바스크립트만 합쳐준다.
    mode: 'development', // 실서비스: production
    devtool: 'eval', // 빌드를 빠르게 하겠다. 실서비스: hidden-source-map
    resolve: {
        extensions: ['.js', '.vue'], // import 등 파일에 접근할때 확장자를 생략할 수 있게 해준다.
    },
    entry: { // 가장 대표적인 파일
        app: path.join(__dirname, 'main.js'), // app은 하나로 합쳐질 파일이름. main.js에 연결된 모든 파일이 하나로 합쳐진다. (main.js + NumberBaseball.js파일)
    },
    module: { // 예외적인 상황에서 이걸쓴다
        rules: [{
            test: /\.vue$/, // .vue 로 끝나는 파일을 만나면
            use: 'vue-loader', // vue-loader를 사용한다.
        }, {
            test: /\.css$/, // .css 로 끝나는 파일을 만나면
            use: [
                'vue-style-loader',
                'css-loader'
            ], // vue-style-loader, css-loader를 사용한다.
        }]
    }, // 웹팩의 핵심. 합칠때 어떻게 합칠건지 정의한다
    plugins: [ // 후처리하느 는낌
        new VueLoaderPlugin(), // 에러로그에서 넣으라고해서 넣음
    ], // 부가적인 부분
    output: {
        filename: '[name].js', // app.js 알아서 app이름이 name에 들어간
        // 합쳐진 js파일이 현재 경로의 dist 폴더에 저장됨
        // 절대경로로 지정해야되는데 C~ 이런식으로 쓸수 없으므로 path 모듈을 사용한다.
        path: path.join(__dirname, 'dist'), // ./zerocho/dist 와 동일함
        publicPath: '/dist/', // 가상경로. 실제경로는 위에 path와 같다. 웹팩이 빌드한 파일을 가상으로 불러온다.
    },
}