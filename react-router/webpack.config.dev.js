const merge = require('webpack-merge');
const baseConfig = require('./webpack.config.base');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const convert = require('koa-connect');
const history = require('connect-history-api-fallback');

module.exports = merge(baseConfig, {
  mode: 'development',
  devtool: 'cheap-module-eval-source-map',
  serve: {
    add: (app, middleware, options) => {
      app.use(convert(history()));
    },
    hot: true,
    open: true
  },
  plugins: [
    new CleanWebpackPlugin()
  ]
});