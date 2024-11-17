const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    //自定义配置启动端口
    port: 7002,
    
    // 您可以继续添加其他devServer的配置项，例如：
    proxy: {
      '/': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        pathRewrite: { '^/': '' }
      }
    }
  }
})
