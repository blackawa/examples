const path = require('path');
const webpack = require('webpack');

module.exports = {
  mode: 'development',
  entry: ['webpack-hot-middleware/client', './src/index.js'],
  output: {
    path: path.resolve(__dirname, 'public'),
    filename: 'bundle.js',
    publicPath: 'public'
  },
  module: {
    rules: [
      {
        test: /\.js/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env', '@babel/preset-react']
          }
        }
      }
    ]
  },
  devServer: {
    contentBase: path.resolve(path.join(__dirname, 'public')),
    port: 3000,
  },
  devtool: 'cheap-module-eval-source-map',
  plugins: [
    new webpack.HotModuleReplacementPlugin(),
  ]
};