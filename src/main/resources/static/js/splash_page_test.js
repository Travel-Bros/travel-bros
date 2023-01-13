let path = document.querySelector('path');
// let pathLength = document.getTotalLength()
let pathLength = path.getTotalLength();

path.style.strokeDasharray = pathLength + ' ' + pathLength;

path.style.strokeDashoffset = pathLength;

// $(window).scroll(function() {
//     if($(window).scrollTop() + $(window).height() === $(document).height()) {
//         alert('does this work?')
//     }
// });

window.addEventListener('scroll', () => {
    // What % is down is it?
    var scrollPercentage = (document.documentElement.scrollTop + document.body.scrollTop) / (document.documentElement.scrollHeight - document.documentElement.clientHeight);
    // Length to offset the dashes
    var drawLength = pathLength * scrollPercentage;

    // Draw in reverse
    path.style.strokeDashoffset = pathLength - drawLength;
});
//
// let path = document.querySelector('path')
// let pathLength = document.getTotalLength()
//
// path.style.strokeDasharray = pathLength + ' ' + pathLength;
//
// path.style.strokeDashoffset = pathLength;