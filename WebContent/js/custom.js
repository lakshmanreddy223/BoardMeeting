/*
  @Author : Fractalink Design Studio
  @Project : Niyogin
  @Dev : Darshan
  @Date : 22/08/2017;
*/


/* Document Ready */
var dragSwiper;
var swiperStory;

var deviceWidth = $(window).width();

function accordian() {
    $('.bs-accordian .title').on('click', function() {
        var obj = this;
        setTimeout(function() {
            if ($(obj).hasClass('collapsed')) {
                $(obj).parents(".panel").removeClass("active");
                $(obj).next(".icon").removeClass("active");
            } else {
                $(".bs-accordian .panel").removeClass("active");
                $(".bs-accordian .panel-title .icon").removeClass("active");
                $(obj).parents(".panel").addClass("active");
                $(obj).next(".icon").addClass("active");
            }
        }, 1);
    });
}

function accordionAllPolicies() {
    $(".mod-policy .btn.typ-bottom-align").on('click', function() {
        var obj = this;
        $(obj).parent(".mod-policy").find(".desc .show-more-wrap").slideToggle();
        $(obj).toggleClass("active");
        if ($(obj).hasClass("active")) {
            $(obj).html("Show Less");
        } else {
            $(obj).html("View all policies");
        }
    });
}

function accordionInvestorMore() {
    $(".js-show-more").on("click", function() {
        var obj = this;
        $(obj).parent(".cm-container").find(".mod-extrainfo").slideToggle();
        $(obj).toggleClass("active");
        if ($(obj).hasClass("active")) {
            $(obj).find('span').text("Show Less");
            $(obj).parents(".sec-inner").addClass("bg-grey");
        } else {
            $(obj).find('span').text("Read More");
            $(obj).parents(".sec-inner").removeClass("bg-grey");
        }
    });
}

function accordionNewsroomMob() {
    for (var i = 0; i < $(".lyt-news .item").length; i++) {
        console.log("loop")
        if (i > 2) {
            console.log("3 se aagye")
            $(".lyt-news .item").eq(i).addClass("hidden");
        }
    }
    $(".lyt-news .js-view-more").on("click", function() {
        var obj = this;
        $(obj).parent(".lyt-news").find(".item.hidden,.item.shown").toggleClass('shown hidden');
        $(obj).toggleClass("active");
        if ($(obj).hasClass("active")) {
            $(obj).html("Show Less");
        } else {
            $(obj).html("View More");
        }
    });
}

function accordionCareers() {
    $('.lyt-careers .title-wrap').on('click', function() {
        var obj = this;
        setTimeout(function() {
            if ($(obj).hasClass('collapsed')) {
                $(obj).find(".icon").removeClass("active");
            } else {
                $(".lyt-careers .mod-job-posting").removeClass("active");
                $(".lyt-careers .title-wrap .icon").removeClass("active");
                $(obj).find(".icon").addClass("active");
            }
        }, 1);
    });
}

function otpInput() {
    $(".input-group.typ-otp input").on('keyup', function() {
        this.value = this.value.replace(/[!,@,#,$,%,^,&,*,(,),_,\-,+,=,\[,\],\{,\},\:,\;,\",\',\?,<,>,\/,|,\\,~,` \.]/g, '');
        var obj = this;
        var key = event.keyCode || event.charCode;
        // console.log(key);
        // console.log($(obj).val() + 'value');
        if ($(obj).val().length == 1) {
            $(obj).next().focus();
        }
        if (key == 8 || key == 46) {
            $(obj).val('').prev().focus();
        }
    })
}

function accordionTeam() {
    var divideNum = 3;

    $(".mod-team .head-wrap").on("click", function() {
        var obj = this;
        $(this).parents().find('.item').removeClass('active');
        if ($(this).hasClass("active") == false) {
            $(this).parents('.item').addClass('active');
            $(obj).parents('.lyt-team').find('.dynamic-desc').remove();
            // $(".lyt-team .dynamic-desc").remove();
            $(".mod-team .head-wrap").removeClass('active');
            $(this).addClass("active");
            var indexEle = $(this).parents(".item").index();
            var calcMod = indexEle + (divideNum - (indexEle % divideNum));
            console.log(indexEle + 'IndexElement');
            console.log(calcMod + 'Calculated Index To Open');
            var dt = $(obj).parents('.lyt-team').find('.item').eq(indexEle).find(".desc").html()
            var temp = '<li class="dynamic-desc">' + dt + '</li>';

            if (device.desktop() == true || device.tablet() == true || $('.mobile.landscape').length != 0) {
                $(obj).parents('.lyt-team').find('.item').eq(calcMod - 1).after(temp);
            } else {
                $(obj).parents('.lyt-team').find('.item').eq(indexEle).after(temp);
            }

            setTimeout(function() {
                $(obj).parents('.lyt-team').find('.dynamic-desc').slideDown('300');
                $("html,body").animate({
                    scrollTop: $(obj).parents('.lyt-team').find('.dynamic-desc').offset().top - 150
                }, 500)
            }, 100);
        } else {
            $(this).parents('.item').removeClass('active');
            $(obj).parents('.lyt-team').find('.dynamic-desc').slideUp('300');
            setTimeout(function() {
                $(obj).parents('.lyt-team').find('.dynamic-desc').remove();
            }, 500);
            $(".mod-team .head-wrap").removeClass('active');
        }

    })

    $(".lyt-team").on('click', '.icon-close', function() {
        var obj = this;
        $(obj).parents('.lyt-team').find('.item').removeClass('active');
        $(obj).parents('.lyt-team').find('.dynamic-desc').slideUp('300');
        setTimeout(function() {
            $(obj).parents('.lyt-team').find('.dynamic-desc').remove();
        }, 500);
        $(obj).parents('.lyt-team').find(".mod-team .head-wrap").removeClass('active');
    });
}

function requestScroll() {
    $(".js-request-scroll").on("click", function() {
        $("html,body").animate({
            scrollTop: $("#requestinvite").offset().top - $(".bs-header").height()
        }, 500)

        $(".js-submit-details").click();
    });
}

function downloadPressScroll() {
    $(".js-download").on("click", function() {
        $("html,body").animate({
            scrollTop: $("#downloadpresskit").offset().top - $(".bs-header").height()
        }, 500);
    });
}

function incrDicr() {
    var quantitiy = 0;
    $('.js-plus').click(function(e) {
        e.preventDefault();
        var that = $(this).parent().siblings('.input-number');
        var quantity = parseInt(that.val());
        that.val(quantity + 1);
    });
    $('.js-minus').click(function(e) {
        e.preventDefault();
        var that = $(this).parent().siblings('.input-number');
        var quantity = parseInt(that.val());
        if (quantity > 0) {
            that.val(quantity - 1);
        }
    });
}


function bannerFix() {
    var winH = $(window).height();
    if ($('.tablet').length != 0) {
        var calH = winH;
        if ($('.landscape').length != 0) {
            var calH = winH - 66
        }
    } else if ($('.desktop').length != 0) {
        var calH = winH - 66;
    } else if ($('.mobile').length != 0) {
        if ($('.landscape').length != 0) {
            var calH = winH;
        }
    }
    $('.pg-home .lyt-banner .mod-banner .item').css('height', calH);
}

function bannerFixMob() {
    var winH = $(window).height();
    $('.lyt-banner .mod-banner .item').css('height', winH);

}


function removeSwiperDesktop() {
    $('.sec-card').find('.lyt-card').removeClass('swiper-container').removeClass('swiper-wrapper');
    $('.sec-card').find('.lyt-card .item').removeClass('swiper-slide');
}

function hoverCardActive() {
    $('.lyt-card.typ-no-tab .item').hover(function() {
        $('.lyt-card .item').removeClass('active');
        $(this).addClass('active');
    });
}

function tabCardActive() {
    $('.lyt-card.typ-investor .item').click(function() {
        $('.lyt-card .item').removeClass('active');
        $(this).addClass('active');
    });
}

function menuOpenClose() {
    $('.bs-header .cm-menu-btn').on('click', function() {
        $('body').addClass('cm-overflow');
        $('.lyt-menu').addClass('active');
        $('.cm-overlay').addClass('active');
    });
    $('.lyt-menu .js-close').on('click', function() {
        $('body').removeClass('cm-overflow');
        $('.lyt-menu').removeClass('active');
        $('.cm-overlay').removeClass('active');
        // $('.lyt-menu .cm-menu-btn').removeClass('active');
    });
    $('.cm-overlay').on('click', function() {
        $('body').removeClass('cm-overflow');
        $('.lyt-menu').removeClass('active');
        $('.cm-overlay').removeClass('active');
        // $('.lyt-menu .cm-menu-btn').removeClass('active');
    });
    setTimeout(function() {
        $('.lyt-menu .cm-menu-btn').addClass('active');
    }, 2000);
}

function stickyHeader() {
    var winH = $(window).height();

    var scrollPos = 0;
    $(window).scroll(function() {
        scrollPos = $(window).scrollTop();
        if (device.mobile() == true) {
            winH = 480;
        }
        if (scrollPos > winH) {
            // console.log(scrollPos)
            $('.bs-header').addClass('sticky');
        } else {
            $('.bs-header').removeClass('sticky');
        }
    });
}

function requestFormShow() {
    $('.sec-request-invite .js-submit-details').on('click', function() {
        $('.sec-request-invite .sec-act-wrap').addClass('hide');
        $('.sec-request-invite .sec-cont').slideDown(300);
    });
}

function bannerBg(obj, objItem, objSrc) {

    $(obj).find(objItem).each(function() {
        var imgSrc = $(this).find(objSrc).attr('src');

        $(this).css("background-image", "url(" + imgSrc + ")");
    });

}

function jobApplyFlyout() {
    $(".lyt-careers .js-apply").on("click", function() {
        $(".lyt-careers .tab-content").find(".bs-form.typ-job-application").addClass("active");
        $("html,body").animate({
            scrollTop: $("#jobapplication").offset().top - $(".bs-header").height() - 20
        }, 500);
    });
    $(".lyt-careers .js-back-apply").on("click", function() {
        $(".lyt-careers .tab-content").find(".bs-form.typ-job-application").removeClass("active");
        // console.log("hi");
    })
}

function faqReadMoreAccordian() {
    $('.js-target').hide();
    $('.js-trigger').on('click', function() {
        var obj = this;
        $(obj).prev('.js-target').slideToggle();
        $(obj).toggleClass("active");
        if ($(obj).hasClass("active")) {
            $(obj).html("Show Less");
        } else {
            $(obj).html("Read More");
        }
    });
}

function pressreleaseReadmore() {
    $('.js-target').hide();
    $('.js-trigger').on('click', function() {
        var obj = this;
        $(obj).prev('.js-target').slideToggle();
        $(obj).toggleClass("active");
        if ($(obj).hasClass("active")) {
            $(obj).html("Show Less");
        } else {
            $(obj).html("Read More");
        }
    });
}

function bannerScroll() {
    $(".js-scroll").on("click", function() {
        $("html,body").animate({
            scrollTop: $(".js-target-div").offset().top - $(".bs-header").height()
        }, 500)
    });
}

function scrollAnimation() {
    new WOW().init();
}

function showToast() {
    $('.js-toast-trigger').on('click', function() {
        $('.bs-toast').addClass('active');
        setTimeout(function() {
            $('.bs-toast').removeClass('active');
        }, 5000);
    });
}

function initMap() {
    var myLatlng = { lat: 18.9968743, lng: 72.8222446 };
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 18,
        center: myLatlng
    });
    var marker = new google.maps.Marker({
        position: myLatlng,
        map: map
    });
}

function iconAnimate() {
    console.log("initial function")
    $('.js-icon-animate').each(function(e) {
        // console.log("heyya")
        var obj = $(this);
        var src1 = $(obj).attr('src');
        var gifImgSrc = src1.split('.');
        var gifImg = gifImgSrc[0] + ".svg";
        // console.log(gifImg);
        $("body").append("<img class='cm-gifload' width='1' height='1' src=" + gifImg + "> ");

        $(this).attr('src', src1.replace('.svg', '.gif'));
        $(obj).hover(function() {
            $(this).attr('src', src1.replace('.svg', '.gif'));
        }, function() {
            $(this).attr('src', src1);
        });
    });
}

function iconAnimation() {

    var iconAnimPos = [];
    $('.js-sec-anim').each(function() {
        var obj = this;
        var tempIcon = {
            eleRef: obj,
            eleTopPos: $(obj).offset().top - 100,
            eleHieght: $(obj).offset().top + $(obj).height()
        }
        iconAnimPos.push(tempIcon);
    });


    $(window).scroll(function() {
        var currentScrollPos = $(window).scrollTop();
        $.each(iconAnimPos, function(index, value) {
            var startPoint = value.eleTopPos
            var endPoint = value.eleHieght
                //console.log($(value.eleRef).find(".lyt-card.typ-no-tab").length);
            if ($(value.eleRef).find(".lyt-card.typ-no-tab").length == 0) {
                if (currentScrollPos > startPoint && currentScrollPos < endPoint) {
                    $(value.eleRef).find(".js-icon-animate").trigger('mouseover');
                } else {
                    $(value.eleRef).find(".js-icon-animate").trigger('mouseout');
                }
            }

        })

    });


    // console.log(iconAnimPos);

}

function numberWithCommas() {
    $(".inr-input").on('change', function() {
        var x = $(this).val();
        $(this).val(x.toString().replace(/,/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ","));

    });
}

function editDetail() {
    $('.edit-detail-btn').on('click', function(e) {
        e.preventDefault();
        $(this).siblings('ul:not(.edit-state)').hide();
        $('.edit-state').fadeIn(450);
        $(this).hide();
        $('.save-detail-btn').fadeIn();

    });
    $('.save-detail-btn').on('click', function(e) {
        e.preventDefault();
        $(this).siblings('ul').hide();
        $(this).siblings('ul').not('.edit-state').fadeIn(450);
        $(this).hide();
        $('.edit-detail-btn').fadeIn();

    });
}

function recalculateEMI() {
    $('.recalculate-btn').on('click', function(e) {
        e.preventDefault();
        $('.tooltip-wrap .subtext').hide();
        $(this).hide();
        $('.btn-ok').fadeIn();
        $('.recalculate-form').fadeIn();
        $('.tooltip-wrap').addClass('bigger');
        $('.btn-apply-now').addClass('btn-disabled');
    });
    $('.btn-ok').on('click', function(e) {
        e.preventDefault();
        $('.tooltip-wrap').removeClass('bigger');
        $('.tooltip-wrap .subtext').show();
        $(this).hide();
        $('.recalculate-btn').fadeIn();
        $('.recalculate-form').slideUp(400);
        $('.btn-apply-now').removeClass('btn-disabled');
    });
}

function productSwiper() {
    var productSwiper;
    if (deviceWidth < 768) {
        productSwiper = new Swiper('.product-swiper', {
            slidesPerView: 'auto',
            centeredSlides: true,
            spaceBetween: 15,
        });
    } else {
        // productSwiper.destroy();
        $('.product-swiper').removeClass('swiper-container');
        $('.product-wrap').removeClass('swiper-wrapper');
        $('.product-wrap li').removeClass('swiper-slide');
    }

}

function calcEligibility() {
    $('.btn-calc-eligibility').on('click', function(e) {
        e.preventDefault();
        /* animate style 1
        $('.mod-banner').not('.typ-calc').fadeOut().promise().done(function() {
            $('.mod-banner.typ-calc').addClass('active');

        });

        setTimeout(function() {

            $('.tooltip-wrap').addClass('active');
        }, 800);
        */

        // animate style2
        if (deviceWidth <= 1024) {
            $('.label-state').fadeOut();
        } else {
            $('.label-state').fadeIn();
        }
        $('.edit-state').hide();
        $('.edit-detail-btn').fadeIn();

        $('.lyt-eligibility-list').addClass('typ-two');
        $('.animate-wrap').slideDown();
        $('.lyt-banner .img-wrap').slideUp(500);
        $('.banner-cont > .title').html('Getting loans has never been so simple');
        setTimeout(function() {
            $('.tooltip-wrap').addClass('active');
        }, 800);

    })
}

function viewAll() {
    $('.btn-view-all').on('click', function() {
        $(this).siblings('ul').find('li').fadeIn(800);
        $(this).hide();
    });
}

$(function() {
    if ($('.btn-calc-eligibility').length) {
        calcEligibility();
    }
    if ($('.btn-view-all').length) {
        viewAll();
    }
    if ($('.product-swiper').length) {
        productSwiper();
    }
    if ($('.edit-detail-btn').length) {
        editDetail();
    }
    if ($('.recalculate-btn').length) {
        recalculateEMI();
    }

    numberWithCommas();
    //component js starts
    if ($('.desktop').length != 0) {
        scrollAnimation();
    }

    iconAnimate();

    $("a").each(function() {
        if ($(this).attr("href") == "#" || $(this).attr("href") == " ") {
            $(this).attr("href", "javascript:void(0)");
        }
    });

    if ($('.lyt-banner').length != 0) {
        if (deviceWidth >= 1280 || $('.tablet.landscape').length != 0 || $('.mobile.landscape').length != 0) {
            bannerBg('.js-bg-img', '.item', '.d-img');
        } else if (deviceWidth <= 1024 && deviceWidth >= 1200) {
            bannerBg('.js-bg-img', '.item', '.t-img');
        } else if (deviceWidth <= 800) {
            bannerBg('.js-bg-img', '.item', '.m-img');
        }
        var swiper = new Swiper('.lyt-banner.typ-home .swiper-container', {
            slidesPerView: 1,
            loop: true,
            autoplay: 6000,
            autoplayDisableOnInteraction: false,
            speed: 1500,
            pagination: ".lyt-banner.typ-home .swiper-pagination",
            paginationClickable: true,
            paginationElement: 'span',
            breakpoints: {
                768: {
                    autoplayDisableOnInteraction: false,
                    followFinger: true
                }
            },
            onSlideChangeStart: function(swiper) {
                console.log("slide change")
                var activeIndx = $('.swiper-slide.swiper-slide-active').attr('data-swiper-slide-index');
                var slideLen = swiper.slides.length - 2;
                var calculateSlide = parseFloat(100 / slideLen);
                var barDistance = activeIndx * calculateSlide;
                $(".page-bar").width(calculateSlide + '%');
                $(".page-bar").css({ left: (barDistance + "%") })
            }

        });

    }
    if ($('.bs-accordian').length != 0) {
        accordian();
    }

    if ($('.input-group.incr-dicr').length != 0) { incrDicr(); }

    if ($('.js-select').length != 0) {
        $(".js-select").select2({ minimumResultsForSearch: -1 });
        console.log("hi");
        $('#selectround').on('change', function(evt) {
            var currentIndx = evt.target.selectedIndex;
            $(this).parents(".bs-tab").find(".nav-tabs .item").eq(currentIndx).find(".nav-link").click();
        });
    }

    if ($('.input-group.typ-otp').length != 0) {
        otpInput();
    }

    if ($('.js-sec-anim').length != 0) {
        iconAnimation();

    }

    if ($('.bs-toast').length != 0) {
        showToast();
    }

    //component js Ends

    if ($('.lyt-faq').length != 0) {

        faqReadMoreAccordian()
    }

    if ($('.bs-sec.sec-press-release').length != 0) {
        pressreleaseReadmore();
    }

    if ($('.lyt-policy').length != 0) {
        // accordianPolicy();
        accordionAllPolicies()
    }
    accordionInvestorMore();
    downloadPressScroll();
    if ($('.lyt-banner').length != 0) {
        bannerFix();
    }
    if ($('.desktop').length != 0) {

        if ($('.lyt-card').length != 0) {
            hoverCardActive();
        }
        if ($('.lyt-card.typ-investor').length != 0) {
            tabCardActive();
        }
    }

    if ($('.lyt-banner').length != 0) { bannerScroll(); }
    if ($('.lyt-card').length != 0) {
        if (deviceWidth <= 800) {
            dragSwiper = new Swiper('.sec-card .swiper-container', {
                centeredSlides: true,
                paginationClickable: true,
                slidesPerView: 'auto',
                spaceBetween: 2,
                initialSlide: 0,
                breakpoints: {
                    500: {
                        slidesPerView: 'auto'
                    }
                },
                onSlideChangeStart: function(swiper) {
                    var currentIndx = swiper.activeIndex;
                    $(".lyt-card").find('.swiper-wrapper .swiper-slide').eq(currentIndx).find('a').click();
                }
            });
        } else if (device.mobile() == true && $('.landscape').length != 0) {
            removeSwiperDesktop();
        } else if (device.desktop() == true) {
            removeSwiperDesktop();
        } else if ($('.tablet .lyt-card.typ-investor').length == 0) {
            removeSwiperDesktop();
        } else if ($('.tablet .lyt-card.typ-investor').length > 0) {
            if ($('.tablet.portrait').length != 0) {
                dragSwiper = new Swiper('.sec-card .swiper-container', {
                    centeredSlides: true,
                    paginationClickable: true,
                    slidesPerView: 3,
                    spaceBetween: 0,
                    initialSlide: 2,
                    onSlideChangeStart: function(swiper) {
                        var currentIndx = swiper.activeIndex;
                        $(".lyt-card").find('.swiper-wrapper .swiper-slide').eq(currentIndx).find('a').click();
                    }
                })
            } else if ($('.tablet.landscape').length != 0 || $('.mobile.landscape').length != 0) {
                dragSwiper = new Swiper('.sec-card .swiper-container', {
                    centeredSlides: true,
                    paginationClickable: true,
                    slidesPerView: 5,
                    spaceBetween: 0,
                    initialSlide: 2,
                    onSlideChangeStart: function(swiper) {
                        var currentIndx = swiper.activeIndex;
                        $(".lyt-card").find('.swiper-wrapper .swiper-slide').eq(currentIndx).find('a').click();
                    }
                })
            }

        }
        if ($('.lyt-card.typ-investor').length != 0) {
            $('.lyt-card.typ-investor a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
                $('.item').removeClass('active');
                $(this).parents('.item').addClass('active');
                var tabIndex = $(".lyt-card.typ-investor a[data-toggle='tab']").index(e.target);
                dragSwiper.slideTo(tabIndex);
            });
        }

    }
    if ($('.mobile').length != 0) {
        if ($('.portrait').length != 0) {
            if ($('.lyt-news').length != 0) {
                accordionNewsroomMob();
            }
        }

        if ($('.lyt-banner').length != 0) {
            bannerFixMob();
        }
    }

    if ($('.lyt-banner.typ-story').length != 0) {
        swiperStory = new Swiper('.typ-story .swiper-container', {
            slidesPerView: 1,
            loop: true,
            autoplay: 3000,
            autoplayDisableOnInteraction: true,
            speed: 1500,
            nextButton: '.lyt-banner.typ-story .button-next',
            prevButton: '.lyt-banner.typ-story .button-prev',
            pagination: ".lyt-banner.typ-story .swiper-pagination",
            paginationClickable: true,
            paginationElement: 'span',
            onSlideChangeStart: function(swiperStory) {
                var activeIndx = $('.lyt-banner.typ-story .swiper-slide.swiper-slide-active').attr('data-swiper-slide-index');
                var slideLen = swiperStory.slides.length - 2;
                var calculateSlide = parseFloat(100 / slideLen);
                var barDistance = activeIndx * calculateSlide;
                $(".page-bar").width(calculateSlide + '%');
                $(".page-bar").css({ left: (barDistance + "%") })
            },
        });
    }
    $('.lyt-banner.typ-story .slider-wrap .item').on('mouseover', function() {
        swiperStory.stopAutoplay();
    });
    $('.lyt-banner.typ-story .slider-wrap .item').on('mouseout', function() {
        swiperStory.startAutoplay();
    });

    if ($('.lyt-menu').length != 0) {
        menuOpenClose();
    }

    if ($('.js-pg-home').length != 0) {
        stickyHeader();
    }
    if ($('.pg-product').length) {
        $('.bs-header').addClass('sticky');
    }

    if ($('.sec-request-invite').length != 0) {
        requestFormShow()
        requestScroll();
    }

    if ($(".lyt-team").length != 0) {
        accordionTeam();
    }

    if ($('.lyt-careers').length != 0) {
        accordionCareers()
        jobApplyFlyout()
    }

    if (deviceWidth > 1024) {
        $('.js-tooltip').tooltipster({
            contentCloning: true,
            animation: 'fade',
            delay: 200,
            theme: 'tooltipster-shadow'
        });
    }

    if (deviceWidth <= 1024) {
        $('.js-tooltip').on('click', function() {
            var targetId = $(this).attr('id');
            var tempDate = "#modal_" + targetId;
            $(tempDate).modal('show');
        });
    }


});