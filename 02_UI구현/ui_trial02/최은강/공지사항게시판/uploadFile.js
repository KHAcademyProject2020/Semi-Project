$(document).on('change', '.file-input', function () {
  let $filename = $(this).val();

  if ($filename == '') $filename = '파일을 선택해주세요.';

  $('.filename').text($filename);
});
