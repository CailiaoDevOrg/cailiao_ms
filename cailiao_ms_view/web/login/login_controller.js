exports.loginCheck = function(req, res, next) {
    var userName = req.body.userName;
    var password = req.body.password;
    if (userName === 'admin' && password === 'admin') {
        res.send(true);
    } else {
        res.send(false);
    }
}