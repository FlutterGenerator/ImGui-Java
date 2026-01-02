#include <pthread.h>
#include <jni.h>
#include <Includes/Utils.h>
#include <thread>
#include <chrono>
#include <Substrate/SubstrateHook.h>
#include "KittyMemory/MemoryPatch.h"
#include "And64InlineHook/And64InlineHook.hpp"

extern "C" {

/*Time For Bools And all*/
struct My_Patches {
MemoryPatch Aim, PickupWeaponVisible, ShopAlwaysVisible, NoRecoilCtoshair, UnlimitedCliP, NoDead, CurrentTimeRound, Ammo, SmallCrosshair, AntiFlashBang, UnlimitedMoney, AManHit, UAnimMontage, USkinEditorWidget, SpawnPlayerCameraManager, UpdateCameraManager, FastLobby, AutoFireWeapons, FreezeMoney, NoGravity, SpeedHack;
} hexPatches;

bool aim = false;//1
bool pickupweaponvisible = false;//2
bool shopalwaysvisible = false;//3
bool norecoilctoshair = false;//4
bool unlimitedclip = false;//5
bool nodead = false;//6
bool currenttimeround = false;//7
bool ammo = false;//8
bool smallcrosshair = false;//9
bool antiflashbang = false;//10
bool unlimitedmoney = false;//11
bool amanhit = false;//12
bool uanimmontage = false;//13
bool uskineditorwidget = false;//14
bool spawnplayercameramanager = false;//15
bool updatecameramanager = false;//16
bool fastlobby = false;//17
bool autofireweapons = false;//18
bool freezemoney = false;//19
bool nogravity = false;//20
bool speedhack = false;//21

const char *libName = "libUE4.so";

JNIEXPORT jobjectArray  JNICALL Java_il2cpp_Main_getFeatures(JNIEnv *env, jobject activityObject) {
	jobjectArray ret;
	//ТУТОР ТУТОР ТУТОР ТУТОР
	// switch_blockid_featureid_text
	// TITLE_pageid_text
	// slider_1_pageid_text_Max_Min_featureid
	// page_text_text
	const char *features[] = {
	       // ("slider_0_1_Slider_100_0"),//22
		    ("switch_1_➣ Aim"),//1
		    ("switch_2_➣ Pick up Weopon Visible"),//2
			("switch_3_➣ Shop Always Visible"),//3
			("switch_4_➣ No Recoil Ctoshair"),//4
			("switch_5_➣ Unlimited CliP"),//5
			("switch_6_➣ No Dead"),//6
			("switch_7_➣ CurrentTimeRound"),//7
			("switch_8_➣ Ammo"),//8
			("switch_9_➣ Small crosshair"),//9
			("switch_10_➣ Anti Flash Bang"),//10
			("switch_11_➣ Unlimited Money"),//11
			("switch_12_➣ AManHit"),//12
			("switch_13_➣ UAnimMontage"),//13
			("switch_14_➣ USkinEditorWidget"),//14
			("switch_15_➣ SpawnPlayerCameraManager"),//15
			("switch_16_➣ UpdateCameraManager"),//16
			("switch_17_➣ FastLobby"),//17
			("switch_18_➣ AutoFire Weapons"),//18
			("switch_19_➣ FreezeMoney"),//19
			("switch_20_➣ NoGravity"),//20
			("switch_21_➣ SpeedHack"),//21
		
	};
	int Total_Feature = (sizeof features /
						 sizeof features[0]); //Now you dont have to manually update the number everytime;
	
	ret = (jobjectArray) env->NewObjectArray(Total_Feature, env->FindClass("java/lang/String"), env->NewStringUTF(""));
	int i;
	for (i = 0; i < Total_Feature; i++)
		env->SetObjectArrayElement(ret, i, env->NewStringUTF(features[i]));
	return (ret);
}

JNIEXPORT void JNICALL
Java_il2cpp_Main_Changes(JNIEnv *env,jobject activityObject,jint feature,jint value) {
	/*  FEATURES  */
	switch (feature) {

	 case 1:
     aim = !aim;
     if (aim){
     hexPatches.Aim.Modify();
   } else {
    hexPatches.Aim.Restore();
	}
     break;
     
     case 2:
     pickupweaponvisible = !pickupweaponvisible;
     if (pickupweaponvisible){
     hexPatches.PickupWeaponVisible.Modify();
   } else {
    hexPatches.PickupWeaponVisible.Restore();
	}
     break;
     
     case 3:
     shopalwaysvisible = !shopalwaysvisible;
     if (shopalwaysvisible){
     hexPatches.ShopAlwaysVisible.Modify();
   } else {
    hexPatches.ShopAlwaysVisible.Restore();
	}
     break;
     
     case 4:
     norecoilctoshair = !norecoilctoshair;
     if (norecoilctoshair){
     hexPatches.NoRecoilCtoshair.Modify();
   } else {
    hexPatches.NoRecoilCtoshair.Restore();
	}
     break;
     
     case 5:
     unlimitedclip = !unlimitedclip;
     if (unlimitedclip){
     hexPatches.UnlimitedCliP.Modify();
   } else {
    hexPatches.UnlimitedCliP.Restore();
	}
     break;
     
     case 6:
     nodead = !nodead;
     if (nodead){
     hexPatches.NoDead.Modify();
   } else {
    hexPatches.NoDead.Restore();
	}
     break;
     
     case 7:
     currenttimeround = !currenttimeround;
     if (currenttimeround){
     hexPatches.CurrentTimeRound.Modify();
   } else {
    hexPatches.CurrentTimeRound.Restore();
	}
     break;
     
     case 8:
     ammo = !ammo;
     if (ammo){
     hexPatches.Ammo.Modify();
   } else {
    hexPatches.Ammo.Restore();
	}
     break;
     
     case 9:
     smallcrosshair = !smallcrosshair;
     if (smallcrosshair){
     hexPatches.SmallCrosshair.Modify();
   } else {
    hexPatches.SmallCrosshair.Restore();
	}
     break;
     
     case 10:
     antiflashbang = !antiflashbang;
     if (antiflashbang){
     hexPatches.AntiFlashBang.Modify();
   } else {
    hexPatches.AntiFlashBang.Restore();
	}
     break;
     
     case 11:
     unlimitedmoney = !unlimitedmoney;
     if (unlimitedmoney){
     hexPatches.UnlimitedMoney.Modify();
   } else {
    hexPatches.UnlimitedMoney.Restore();
	}
     break;
     
     case 12:
     amanhit = !amanhit;
     if (amanhit){
     hexPatches.AManHit.Modify();
   } else {
    hexPatches.AManHit.Restore();
	}
     break;
     
     case 13:
     uanimmontage = !uanimmontage;
     if (uanimmontage){
     hexPatches.UAnimMontage.Modify();
   } else {
    hexPatches.UAnimMontage.Restore();
	}
     break;
     
     case 14:
     uskineditorwidget = !uskineditorwidget;
     if (uskineditorwidget){
     hexPatches.USkinEditorWidget.Modify();
   } else {
    hexPatches.USkinEditorWidget.Restore();
	}
     break;
     
     case 15:
     spawnplayercameramanager = !spawnplayercameramanager;
     if (spawnplayercameramanager){
     hexPatches.SpawnPlayerCameraManager.Modify();
   } else {
    hexPatches.SpawnPlayerCameraManager.Restore();
	}
     break;
     
     case 16:
     updatecameramanager = !updatecameramanager;
     if (updatecameramanager){
     hexPatches.UpdateCameraManager.Modify();
   } else {
    hexPatches.UpdateCameraManager.Restore();
	}
     break;
     
     case 17:
     fastlobby = !fastlobby;
     if (fastlobby){
     hexPatches.FastLobby.Modify();
   } else {
    hexPatches.FastLobby.Restore();
	}
     break;
     
     case 18:
     autofireweapons = !autofireweapons;
     if (autofireweapons){
     hexPatches.AutoFireWeapons.Modify();
   } else {
    hexPatches.AutoFireWeapons.Restore();
	}
     break;
     
     case 19:
     freezemoney = !freezemoney;
     if (freezemoney){
     hexPatches.FreezeMoney.Modify();
   } else {
    hexPatches.FreezeMoney.Restore();
	}
     break;
     
     case 20:
     nogravity = !nogravity;
     if (nogravity){
     hexPatches.NoGravity.Modify();
   } else {
    hexPatches.NoGravity.Restore();
	}
     break;
     
     case 21:
     speedhack = !speedhack;
     if (speedhack){
     hexPatches.SpeedHack.Modify();
   } else {
    hexPatches.SpeedHack.Restore();
	}
     break;
     
	}
}

// EXTERN END
}

// ---------- Hooking ---------- //

void *hack_thread(void *) {
hexPatches.Aim = MemoryPatch::createWithHex("libUE4.so",0x028c1fec,"0000A0E31EFF2FE1"); //1
hexPatches.PickupWeaponVisible = MemoryPatch::createWithHex("libUE4.so",0x028abe50,"0100A0E31EFF2FE1"); //2
hexPatches.ShopAlwaysVisible = MemoryPatch::createWithHex("libUE4.so",0x028abda8,"0100A0E31EFF2FE1"); //3
hexPatches.NoRecoilCtoshair = MemoryPatch::createWithHex("libUE4.so",0x028c4694,"0000A0E31EFF2FE1"); //4
hexPatches.UnlimitedCliP = MemoryPatch::createWithHex("libUE4.so",0x02906f54,"0201E0E31EFF2FE1"); //5
//soat kill
hexPatches.NoDead = MemoryPatch::createWithHex("libUE4.so",0x028fa4ac,"0201E0E31EFF2FE1"); //6
hexPatches.CurrentTimeRound = MemoryPatch::createWithHex("libUE4.so",0x028ad880,"0201E0E31EFF2FE1"); //7

//oqi pistolet
hexPatches.Ammo = MemoryPatch::createWithHex("libUE4.so",0x02906f3c,"0201E0E31EFF2FE1"); //8
//money и т.д
hexPatches.SmallCrosshair = MemoryPatch::createWithHex("libUE4.so",0x028c3884,"0100A0E31EFF2FE1"); //9
hexPatches.AntiFlashBang = MemoryPatch::createWithHex("libUE4.so",0x028a310c,"0100A0E31EFF2FE1"); //10
hexPatches.UnlimitedMoney = MemoryPatch::createWithHex("libUE4.so",0x02948fcc,"0201E0E31EFF2FE1"); //11
//паронат немемури
hexPatches.AManHit = MemoryPatch::createWithHex("libUE4.so",0x028bb618,"0100A0E31EFF2FE1"); //12

hexPatches.UAnimMontage = MemoryPatch::createWithHex("libUE4.so",0x028c30e4,"0000A0E31EFF2FE1"); //13
hexPatches.USkinEditorWidget = MemoryPatch::createWithHex("libUE4.so",0x0292104c,"0000A0E31EFF2FE1"); //14
hexPatches.SpawnPlayerCameraManager = MemoryPatch::createWithHex("libUE4.so",0x040fb0c8,"0100A0E31EFF2FE1"); //15
hexPatches.UpdateCameraManager = MemoryPatch::createWithHex("libUE4.so",0x04105db8,"0100A0E31EFF2FE1"); //16
//FastLobby
hexPatches.FastLobby = MemoryPatch::createWithHex("libUE4.so",0x028e6c4c,"0000A0E31EFF2FE1"); //17
hexPatches.AutoFireWeapons = MemoryPatch::createWithHex("libUE4.so",0x02930558,"1EFF2FE1"); //18

hexPatches.FreezeMoney = MemoryPatch::createWithHex("libUE4.so",0x028c6b18,"1EFF2FE1"); //19
hexPatches.NoGravity = MemoryPatch::createWithHex("libUE4.so",0x03cbf7f8,"0100A0E31EFF2FE1"); //20
hexPatches.SpeedHack = MemoryPatch::createWithHex("libUE4.so",0x03cbf81c,"0100A0E31EFF2FE1"); //21

	
    // ---------- Hook ---------- //
	
    return NULL;
}

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *globalEnv;
    vm->GetEnv((void **) &globalEnv, JNI_VERSION_1_6);

    // Create a new thread so it does not block the main thread, means the game would not freeze
    pthread_t ptid;
    pthread_create(&ptid, NULL, hack_thread, NULL);

    return JNI_VERSION_1_6;
}

JNIEXPORT void JNICALL
JNI_OnUnload(JavaVM *vm, void *reserved) {}
