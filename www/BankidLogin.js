"use strict";
// @ts-ignore
var exec = require("cordova/exec");
var loginWithBankId = function (token, success, fail) {
  return exec(success, fail, "BankidLogin", "loginWithBankId", [token]);
};

module.exports = loginWithBankId;
