require pseudo.inc

SRC_URI = "git://git@github.com/Aclima/pseudo;protocol=ssh;branch=master \
           file://0001-configure-Prune-PIE-flags.patch \
           file://fallback-passwd \
           file://fallback-group \
           "

SRCREV = "ef4055a5469eea4ae1a6079812ccd73583841162"
S = "${WORKDIR}/git"
PV = "1.9.0+git${SRCPV}"

# error: use of undeclared identifier '_STAT_VER'
COMPATIBLE_HOST_libc-musl = 'null'
