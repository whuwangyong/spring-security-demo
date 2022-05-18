$(document).ready(function () {
    $('#mynav').load("/html/nav.html", function () {
        $('.navbar-nav li').find('a').each(function () {
            if (this.href == document.location.href || document.location.href.search(this.href) >= 0) {
                $(this).parent().siblings('li').removeClass('active');
                $(this).parent().addClass('active');
            }
        });
    });
});
