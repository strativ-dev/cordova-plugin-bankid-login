#import <Cordova/CDV.h>

@interface BankidLogin : CDVPlugin

- (void)loginWithBankId:(CDVInvokedUrlCommand*)command;

@end