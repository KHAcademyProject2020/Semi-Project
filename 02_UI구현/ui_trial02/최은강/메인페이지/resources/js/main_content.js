$(function () {
  $('.scrollspy-navigation a').click(function (e) {
    e.preventDefault();
    $('body, html').animate(
      {
        scrollTop: $($.attr(this, 'href')).offset().top,
      },
      750
    );
  });

  let top_btn = $('#on-top');
  $(window).scroll(function () {
    console.log('위치: ' + $(window).scrollTop());
    if ($(window).scrollTop() > 300) {
      top_btn.addClass('show');
    } else {
      top_btn.removeClass('show');
    }
  });

  top_btn.click(function (e) {
    e.preventDefault();
    $('html, body').animate(
      {
        scrollTop: 0,
      },
      300
    );
  });
});
