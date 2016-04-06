var express = require('express');
var router = express.Router();
var loginController = require('../web/login/login_controller');

router.get(['/login.html', '/'], function(req, res, next) {
    res.render('login/login');
});

router.post('/login_check.html', function(req, res, next) {
    var userName = req.body.userName;
    var password = req.body.password;
    if (userName === 'admin' && password === 'admin') {
        res.send(true);
    } else {
        res.send(false);
    }
});

module.exports = router;