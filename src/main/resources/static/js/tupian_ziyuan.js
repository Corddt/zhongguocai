// 获取模态窗口和其中的元素
var modal = document.getElementById('myModel');
var modalImg = document.getElementById('img01');
var span = document.getElementsByClassName('close')[0];

// 为所有的小图添加点击事件
var images = document.getElementsByClassName('tupian');
for (var i = 0; i < images.length; i++) {
    images[i].onclick = function(){
        modal.style.display = "block";
        modalImg.src = this.src;
        modal.classList.add('show'); // 添加这一行
    }
}

// 为关闭按钮添加点击事件
span.onclick = function() {
    modal.style.display = "none";
    modal.classList.remove('show'); // 添加这一行
}

// 点击大图的任意位置也可以关闭
modal.onclick = function() {
    modal.style.display = "none";
    modal.classList.remove('show'); // 添加这一行
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
