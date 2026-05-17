package net.themonhub.playeranimationfeatures

import net.fabricmc.api.ModInitializer
import net.themonhub.playeranimationfeatures.FunnyStartup.printFunnyStartupMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object PlayerAnimationFeatures : ModInitializer {
    val logger: Logger = LoggerFactory.getLogger("notuglyanimation")

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		printFunnyStartupMessage()
	}
}