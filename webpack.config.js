const path = require('path');

module.exports = {
  mode: 'development',
  entry: {
    print: './src/main/resources/static/webpack/print.js',
    test: './src/main/resources/static/webpack/test.js',
  },
  devtool: 'inline-source-map',
  devServer: {
    contentBase: './dist',
  },
  output: {
    filename: '[name].bundle.js',
    path: path.resolve(__dirname, 'dist'),
  },
};