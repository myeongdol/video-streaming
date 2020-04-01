const path = require('path');

module.exports = {
  mode: 'development',
  entry: {
    'print': './src/main/resources/static/webpack/print.js',
    'webpack-test': './src/main/resources/static/webpack/webpack-test.js',
  },
  devtool: 'inline-source-map',
  devServer: {
    contentBase: './src/main/resources/static/dist',
  },
  output: {
    filename: '[name].bundle.js',
    path: path.resolve(__dirname, './src/main/resources/static/dist'),
  },
};