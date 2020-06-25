# dosfstools OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Copyright (C) 2015, SÃ¶ren Brinkmann <soeren.brinkmann@gmail>  All Rights Reserved
# Released under the MIT license (see packages/COPYING)
SUMMARY = "DOS FAT Filesystem Utilities"
HOMEPAGE = "https://github.com/dosfstools/dosfstools"

SECTION = "base"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/dosfstools/dosfstools;protocol=ssh \
          "
SRCREV = "cc7514352cee68a8cdcb9ab50f37dc1e1e4b893a"

UPSTREAM_CHECK_URI = "https://github.com/dosfstools/dosfstools/releases"

inherit autotools pkgconfig

DEPENDS += "gettext"

S = "${WORKDIR}/git"

EXTRA_OECONF = "--without-udev --enable-compat-symlinks"

CFLAGS += "-D_GNU_SOURCE -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64"

do_configure_prepend () {
    ( cd ${S}; ./autogen.sh )
}

BBCLASSEXTEND = "native"

# Add codepage437 to avoid error from `dosfsck -l`
RRECOMMENDS_${PN}_append_libc-glibc = " glibc-gconv-ibm437"
