<h1 align="center">Cordova plugin for Bankid login</h1>

Last version 1.0.0

# Install

> Install:

```
cordova plugin add https://github.com/strativ-dev/cordova-plugin-bankid-login.git

cordova prepare
```

> Delete:

```
cordova plugin rm cordova-plugin-bankid-login
```

_Example_

```javascript
window?.plugins?.bankidLogin(
  token,
  (response) => {
    console.log("bankidLogin:response", response);
  },
  (error) => {
    console.log("bankidLogin:error", error);
  }
);
```

Here `token` is Bankid `AUTO_STARTTOKEN`
If success, `response` contains success message.

## License

MIT
Copyright (c) 2023 Strativ AB
