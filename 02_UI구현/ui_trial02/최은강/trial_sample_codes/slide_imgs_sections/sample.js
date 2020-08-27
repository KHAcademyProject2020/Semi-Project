// const navLeft = document.querySelector('.left');
// const navRight = document.querySelector('.right');

// const images = document.querySelector('.images');
// const colors = document.querySelector('.colored-backgrounds');

// let index = 0;

// function right() {
//   transform((index = index < 3 ? ++index : 0));
// }

// function left() {
//   transform((index = index > 0 ? --index : 3));
// }

// navLeft.addEventListener('click', left);
// navRight.addEventListener('click', right);

// function transform(index) {
//   images.style.transform = `translateX(-${index * 100}%)`;
//   colors.style.transform = `translateX(-${index * 100}%)`;
// }

$(function () {
  const navLeft = $('.left');
  const navRight = $('.right');

  const images = $('.images');
  const colors = $('.colored-backgrounds');

  let index = 0;

  function transform(idx) {
    console.log('moved!');
    images.css('translateX', `-${idx * 100}%`);
    colors.css('translateX', `-${idx * 100}%`);
  }

  navLeft.click(function () {
    index = index < 3 ? ++index : 0;
    console.log('left clicked! now index is... =>', index);
    transform(index);
  });

  navRight.click(function () {
    index = index > 0 ? --index : 3;
    console.log('right clicked! now index is... =>', index);
    transform(index);
  });
});
