// 获取模态窗口和其中的元素
var modal = document.getElementById('myModel');
var modalVideo = document.createElement('video'); // 创建一个新的video元素
modalVideo.controls = true; // 添加视频控件
var span = document.getElementsByClassName('close')[0];

// 创建一个新的video元素
var modalVideo = document.createElement('video');
modalVideo.controls = true; // 添加视频控件
modalVideo.className = "model-video"; // 将新的 CSS 类应用到 video 元素


// 为所有的小图添加点击事件
var videos = document.getElementsByClassName('small-img');
for (var i = 0; i < videos.length; i++) {
    videos[i].onclick = function(){
        modal.style.display = "block";
        modalVideo.src = this.src;
        modal.appendChild(modalVideo); // 将新的video元素添加到模态窗口中
        modal.classList.add('show');
    }
}

// 为关闭按钮添加点击事件
span.onclick = function() {
    modal.style.display = "none";
    modal.classList.remove('show');
    modalVideo.pause(); // 在关闭模态窗口时暂停视频
    modal.removeChild(modalVideo); // 从模态窗口中移除video元素
}

// 点击大图的任意位置也可以关闭
modal.onclick = function() {
    modal.style.display = "none";
    modal.classList.remove('show');
    modalVideo.pause(); // 在关闭模态窗口时暂停视频
    modal.removeChild(modalVideo); // 从模态窗口中移除video元素
}

//这是导航栏的js
window.onload = function () {
    var menuItems = document.querySelectorAll('.menu ul li');
    var slider = document.getElementById('slider');

    // 设置初始位置
    setSliderPosition(document.getElementById('home'));

    // 对每个菜单项添加事件监听
    menuItems.forEach(item => {
        item.addEventListener('mouseenter', function () {
            setSliderPosition(item);
        });
    });

    function setSliderPosition(item) {
        var rect = item.getBoundingClientRect();
        slider.style.left = rect.left + 'px';
        slider.style.width = rect.width + 'px';
    }
}

