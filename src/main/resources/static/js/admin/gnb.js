document.addEventListener('DOMContentLoaded', () => {
    let gnb = $('#gnb > li > a');

    gnb.click(function (e) {
      e.preventDefault();
      let isOpen = $(this).next().is(':visible');

      if (isOpen) {
        $(this).next().slideUp(200);
      } else {
        $(this).next().slideDown(200);
      }
    });
  });