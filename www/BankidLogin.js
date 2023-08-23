"use strict";
// @ts-ignore
var exec = require("cordova/exec");
var loginWithBankId = function ({ token, redirectUrl }, success, fail) {
  if (!token) return fail("Token is required");
  if (!redirectUrl) redirectUrl = "null";
  module.exports = loginWithBankId;
  return exec(success, fail, "BankidLogin", "loginWithBankId", [
    token,
    redirectUrl,
  ]);
};

module.exports = loginWithBankId;
