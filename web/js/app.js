/**
 * Created by tyz on 2018/1/9.
 */
require.config({
    baseUrl: '../js',
    paths:{
        zepto: 'lib/zepto.min',
        css: 'css',
        weixin: 'lib/jweixin-1.0.0',
        weui: 'lib/weui.min',
        main: 'app/main'
    },
    'shim':{
        weixin: {
            'deps': ['zepto']
        },
        weui : {
            'deps': ['zepto', 'weixin']
        }
    }
});
require(['zepto', 'weixin', 'weui', 'main'], function ($, weixin, weui, main) {
    main();
})