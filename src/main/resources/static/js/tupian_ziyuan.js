// 获取模态窗口和其中的元素
var modal = document.getElementById('myModel');
var modalImg = document.getElementById('img01');
var span = document.getElementsByClassName('close')[0];

// 为所有的小图添加点击事件
var images = document.getElementsByClassName('small-img');
for (var i = 0; i < images.length; i++) {
    images[i].onclick = function(){
        modal.style.display = "block";
        modalImg.src = this.src;
    }
}

// 为关闭按钮添加点击事件
span.onclick = function() {
    modal.style.display = "none";
}

// 点击大图的任意位置也可以关闭
modal.onclick = function() {
    modal.style.display = "none";
}
