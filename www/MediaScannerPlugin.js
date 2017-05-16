//
//  MediaScannerPlugin.js
//  MediaScannerPlugin PhoneGap/Cordova plugin
//
//  Created by sara.
//  Copyright (c) 2017 sara. All rights reserved.
//  MIT Licensed
//

module.exports = {

    scanFile: function (completeFilePath, successCallback, failureCallback) {
        // successCallback required
        if (typeof successCallback !== "function") {
            console.log("MediaScannerPlugin Error: successCallback is not a function");
        }
        else if (typeof failureCallback !== "function") {
            console.log("MediaScannerPlugin Error: failureCallback is not a function");
        }
        else {
            return cordova.exec(successCallback, failureCallback, "MediaScannerPlugin", "scanFile", [completeFilePath]);
        }
    }
};
