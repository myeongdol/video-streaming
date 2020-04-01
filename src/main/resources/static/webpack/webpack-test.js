import _ from 'lodash';
import printMe from './print.js';
import $ from 'jquery';

function component() {
  const element = document.createElement('div');
  const btn = document.createElement('button');

  element.innerHTML = _.join(['Hello', 'webpack'], ' ');

  btn.innerHTML = 'Click me and check the console!';
  btn.onclick = printMe;

  element.appendChild(btn);

  return element;
}

document.body.appendChild(component());

window.onload = function() {
  var buttonText = $('button').text();
  console.log(buttonText);
}
