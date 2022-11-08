/**
 * Control Module will depend only to core.
 * This module act like domain layer for module to module communication.
 * Everybody that need to communicate between modules shall depend on this module.
 * Since this module also depend to core, this module can act like binder to core API.
 * Everybody that implement this module will be able to interact with core utility.
 */
dependencies {
    api(project(":core:network"))
    api(project(":core:ui"))
}