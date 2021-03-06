SUMMARY = "Utilities for managing the Linux LoWPAN stack"
DESCRIPTION = "This is a set of utils to manage the Linux LoWPAN stack. \
The LoWPAN stack aims for IEEE 802.15.4-2003 (and for lesser extent IEEE 802.15.4-2006) compatibility."

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "libnl python"

PV = "0.3+git${SRCPV}"
SRC_URI = "git://linux-zigbee.git.sourceforge.net/gitroot/linux-zigbee/linux-zigbee \
           file://no-help2man.patch"
SRCREV = "a1d9615adde6d1a568813c24a128273ed755af04"

S = "${WORKDIR}/git"

inherit autotools python-dir pkgconfig

CACHED_CONFIGUREVARS += "am_cv_python_pythondir=${PYTHON_SITEPACKAGES_DIR}/lowpan-tools"

do_install_append() {
	rmdir ${D}${localstatedir}/run
}

FILES_${PN}-dbg += "${libexecdir}/lowpan-tools/.debug/"

PACKAGES =+ "${PN}-python"
FILES_${PN}-python = "${libdir}/python*"
