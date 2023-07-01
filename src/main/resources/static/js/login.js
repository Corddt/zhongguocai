var is_root = 0;
const sp_username = document.getElementById('sp_username');
const sp_password = document.getElementById('sp_password');
const lg_username = document.getElementById('username');
const lg_password = document.getElementById('password');
const login = document.getElementsByClassName('login')[0];
const signup = document.getElementsByClassName('signUp')[0];
const login_mask = document.getElementsByClassName('login_mask')[0];

function log(){
    //获取表单值
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    var a = document.getElementById('error_message');
    login_mask.style.height = '323px';
    //验证账号密码和页面跳转
    if((username == 'admin' && password == 'admin')){
        window.location.href = `../index.html?is_root=1&is_login=1`;
        localStorage.setItem('theme_moden', 0);
        localStorage.setItem('is_root',1);
    }else if(username=='admin' && password!='admin'){
        a.innerText = '密码错误';
    }else if(username.length != 0 && password != 0){
        window.location.href = `../index.html?is_root=0&is_login=1`;
        localStorage.setItem('theme_moden', 0);
        localStorage.setItem('is_root',0);
    }else if(username === '' && password !='' ){
        a.innerText = '用户名不能为空';
    }else if(username != '' && password ===''){
        a.innerText = '密码不能为空';
    }else{
        a.innerText = '用户名和密码不能为空';
    }
}
function sign(){
    //获取表单值
    const username = sp_username.value;
    const password = sp_password.value;
    var a = document.getElementById('sp_error_message');
    // 修改login_mask height
    login_mask.style.height = '323px';
    //验证账号密码是否为空
    if(username === '' && password === '' ){
        a.innerText = '用户名和密码不能为空';
    }else if(username === '' && password !='' ){
        a.innerText = '用户名不能为空';
    }else if(username != '' && password ===''){
        a.innerText = '密码不能为空';
    }else{
        a.innerText = '';
        sp_password.value = ''
        sp_username.value = '';
        login_mask.style.height = '308px';
        confirm(`注册成功！`);
    }
}
//监听登录按钮
document.getElementById('login_idx').addEventListener('click', () => {
    log();
})
// 监听注册按钮
document.getElementById('sign_idx').addEventListener('click', e=>{
    sign();
})
// Enter快捷登录
document.onkeydown = function(e){
    if(e.key == 'Enter'){
        log();
    }
}

document.getElementById('change_login').addEventListener('click', ()=>{
    // 向右移
    login_mask.style.translate = '0px';
    signup.style.display = 'none';
    setTimeout(()=>{
        login.style.display = 'block';
        document.getElementById('change_login').style.display = 'none';
        document.getElementById('change_sign').style.display = 'block';
    },1000);
    // 清空输入框和错误提示内容
    document.getElementById('sp_error_message').innerText = '';
    sp_password.value = ''
    sp_username.value = '';
})
document.getElementById('change_sign').addEventListener('click', ()=>{
    // 向左移
    login_mask.style.translate = '-395px';
    login.style.display = 'none';
    setTimeout(()=>{
        signup.style.display = 'block';
        document.getElementById('change_sign').style.display = 'none';
        document.getElementById('change_login').style.display = 'block';
    },1000);
    // 清空输入框和错误提示内容
    document.getElementById('error_message').innerText = '';
    lg_password.value = ''
    lg_username.value = '';
})