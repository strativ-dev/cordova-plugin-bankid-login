#import "BankidLogin.h"
#import <Cordova/CDV.h>

@implementation BankidLogin



- (void)loginWithBankId:(CDVInvokedUrlCommand*)command {
	NSString *token = [command.arguments objectAtIndex:0];
	NSString *redirect = [command.arguments objectAtIndex:1];
    __block CDVPluginResult * pluginResult = nil;
    
	if (token && [token length] > 0) {
        NSLog(@"NSString2 = %@", token);
        NSString *url = [NSString stringWithFormat:@"https://app.bankid.com/?autostarttoken=%@&redirect=%@", token,redirect];
        NSURL *bankIdLink = [NSURL URLWithString:url];

        if ([[UIApplication sharedApplication] canOpenURL:bankIdLink]) {
            [[UIApplication sharedApplication] openURL:bankIdLink options:@{} completionHandler:^(BOOL success) {
                if (success) {
                    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
                   [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
                }
            }];
        } else {
            NSLog(@"Cannot open the external app.");
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Cannot open the bankid app."];
            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        }
	} else {
		pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Invalid auth token."];
		[self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
	}
}

@end
